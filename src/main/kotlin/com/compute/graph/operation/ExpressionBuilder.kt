package com.compute.graph.operation

import com.compute.graph.antlr.ExpressionBaseListener
import com.compute.graph.antlr.ExpressionParser
import com.compute.graph.graph.StringExpressionGraph
import com.compute.graph.graph.StringExpressionGraphBuilder
import com.compute.graph.graph.StringExpressionGraphListener
import com.compute.graph.operation.annotations.Constant
import com.compute.graph.operation.annotations.ExpressionGraphPart
import com.compute.graph.operation.annotations.Function
import com.compute.graph.operation.annotations.Operator
import com.compute.graph.operation.annotations.Variable
import com.compute.graph.operation.base.MathExpression
import com.compute.graph.operation.base.TransformableExpression
import com.compute.graph.operation.objects.constants.ConstantBuilder
import com.compute.graph.operation.objects.functions.FunctionBuilder
import com.compute.graph.operation.objects.operators.OperatorBuilder
import io.github.classgraph.ClassGraph
import io.github.classgraph.ClassInfo
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.tree.ErrorNode
import org.antlr.v4.runtime.tree.ParseTree
import org.antlr.v4.runtime.tree.RuleNode
import org.antlr.v4.runtime.tree.TerminalNode

object ExpressionBuilder {

    fun build(string: String): MathExpression {
        return build(StringExpressionGraphBuilder.build(string))
    }

    internal fun build(parseTree: ParseTree): MathExpression {
        if (parseTree is ErrorNode || parseTree is TerminalNode) {
            throw java.lang.IllegalStateException("There was unexpected error in parsed tree - ${parseTree.text}")
        }

        val ruleNode = parseTree as RuleNode
        val ctx = ruleNode.ruleContext as ParserRuleContext
        val listener = ExpressionGraphListener()
        ctx.enterRule(listener)
        return listener.result
    }

    fun build(stringGraph: StringExpressionGraph): MathExpression {
        TODO()
    }

    fun scanForExpressions(packages: List<String>) {
        scanPackages(
                packages = packages,
                annotations = listOf(ExpressionGraphPart::class.java.canonicalName),
                extendsClasses = listOf(MathExpression::class.java.canonicalName)
        )
    }

    fun scanForExpressions(vararg packages: String) {
        scanPackages(
                packages = packages.toList(),
                annotations = listOf(ExpressionGraphPart::class.java.canonicalName),
                extendsClasses = listOf(MathExpression::class.java.canonicalName)
        )
    }

    private fun scanPackages(
            packages: List<String> = listOf(""),
            annotations: List<String> = listOf(),
            implementedInterfaces: List<String> = listOf(),
            extendsClasses: List<String> = listOf()
    ) {
        ClassGraph().enableAllInfo()
                .whitelistPackages(*packages.toTypedArray())
                .scan()
                .use {
                    it.allClasses.filter { classInfo ->
                        annotations.all { annotationName -> classInfo.hasAnnotation(annotationName) }
                                && implementedInterfaces.all { interfaceName -> classInfo.implementsInterface(interfaceName) }
                                && extendsClasses.all { className -> classInfo.extendsSuperclass(className) }
                    }.forEach(this::processClass)
                }
    }

    @Suppress("UNCHECKED_CAST")
    private fun processClass(clazz: ClassInfo) {
        var res: Class<out MathExpression>?
        if (clazz.hasAnnotation(Function::class.qualifiedName)) {
            res = clazz.loadClass() as Class<out MathExpression>
            res.getAnnotation(Function::class.java).names.toList()
                    .let {
                        FunctionBuilder.register(it, res!!)
                    }
        }
        if (clazz.hasAnnotation(Operator::class.qualifiedName)) {
            res = clazz.loadClass() as Class<out MathExpression>
            res.getAnnotation(Operator::class.java).names.toList()
                    .let {
                        OperatorBuilder.register(it, res!!)
                    }
        }
        if (clazz.hasAnnotation(Constant::class.qualifiedName)) {
            res = clazz.loadClass() as Class<out MathExpression>
            res.getAnnotation(Constant::class.java).names.toList()
                    .let {
                        ConstantBuilder.register(it, res!!)
                    }
        }
        if (clazz.hasAnnotation(Variable::class.qualifiedName)) {
            // todo what to do here
        }
    }
}

class ExpressionGraphListener : ExpressionBaseListener() {
    lateinit var result: MathExpression

    override fun enterEquation(ctx: ExpressionParser.EquationContext) {
        TODO()
    }

    override fun enterExpression(ctx: ExpressionParser.ExpressionContext) {
        if (ctx.childCount == 1) {
            result = ExpressionBuilder.build(ctx.getChild(0))
        } else {
            val subtract = mutableListOf<MathExpression>()
            val sum = mutableListOf<MathExpression>()
            sum.add(ExpressionBuilder.build(ctx.getChild(0)))

            for (i in 1 until ctx.childCount step 2) {
                val child = ExpressionBuilder.build(ctx.getChild(i + 1))
                if (ctx.getChild(i).text == "-") {
                    subtract.add(child)
                } else {
                    sum.add(child)
                }
            }

            if (sum.size == 1) {
                result = sum.first()
            } else {
                result = OperatorBuilder.buildVectorOperation("+", sum)
            }
            if (subtract.isNotEmpty()) {
                result = if (subtract.size == 1) {
                    OperatorBuilder.buildBinaryOperation("-", result, subtract.first())
                } else {
                    OperatorBuilder.buildVectorOperation("+", subtract).let { subtractPart ->
                        OperatorBuilder.buildBinaryOperation("-", result, subtractPart)
                    }
                }
            }
        }
    }

    override fun enterTerm(ctx: ExpressionParser.TermContext) {
        if (ctx.childCount == 1) {
            result = ExpressionBuilder.build(ctx.getChild(0))
        } else {
            val divide = mutableListOf<MathExpression>()
            val multiply = mutableListOf<MathExpression>()
            multiply.add(ExpressionBuilder.build(ctx.getChild(0)))

            var i = 1
            while (i < ctx.childCount) {
                when {
                    ctx.getChild(i).text == "/" -> {
                        divide.add(ExpressionBuilder.build(ctx.getChild(i + 1)))
                        i += 2
                    }
                    ctx.getChild(i).text == "*" -> {
                        multiply.add(ExpressionBuilder.build(ctx.getChild(i + 1)))
                        i += 2
                    }
                    else -> {
                        multiply.add(ExpressionBuilder.build(ctx.getChild(i)))
                        i++
                    }
                }
            }
            if (multiply.size == 1)
                result = multiply.first()
            else
                result = OperatorBuilder.buildVectorOperation("*", result)
            if (divide.isNotEmpty()) {
                result = if (divide.size == 1) {
                    OperatorBuilder.buildBinaryOperation("/", result,  divide.first())
                } else {
                    OperatorBuilder.buildVectorOperation("*", divide).let {
                        OperatorBuilder.buildBinaryOperation("/", result, it)
                    }
                }
            }
        }
    }

    override fun enterFactor(ctx: ExpressionParser.FactorContext) {
        if (ctx.childCount == 1) {
            result = ExpressionBuilder.build(ctx.getChild(0))
        } else {
            result = StringExpressionGraph("^")
            result.addChild(ExpressionBuilder.build(ctx.getChild(0)))

            for (i in 2 until ctx.childCount step 2) {
                result.addChild(ExpressionBuilder.build(ctx.getChild(i)))
            }
        }
    }

    override fun enterSigned_composed_atom(ctx: ExpressionParser.Signed_composed_atomContext) {
        result = ExpressionBuilder.build(ctx.getChild(0))
        when {
            ctx.childCount == 1 ->
                return
            ctx.childCount == 2 ->
                result.addChild(ExpressionBuilder.build(ctx.getChild(1)))
            else -> {
                throw IllegalStateException("Unexpected child amount - ${ctx.childCount} while parsing ${ctx.text}")
            }
        }
    }

    // todo ended here
    override fun enterComposed_atom(ctx: ExpressionParser.Composed_atomContext) {
        result = ExpressionBuilder.build(ctx.getChild(0))
        when {
            ctx.childCount == 1 ->
                return
            ctx.childCount == 2 ->
                result.addChild(ExpressionBuilder.build(ctx.getChild(1)))
            else -> {
                throw IllegalStateException("Unexpected child amount - ${ctx.childCount} while parsing ${ctx.text}")
            }
        }
    }

    override fun enterAtom(ctx: ExpressionParser.AtomContext) {
        if (ctx.childCount == 1) {
            result = ExpressionBuilder.build(ctx.getChild(0))
        } else {
            result = ExpressionBuilder.build(ctx.getChild(1))
            result.addChild(ExpressionBuilder.build(ctx.getChild(0)))
        }
    }

    override fun enterExpr_in_brackets(ctx: ExpressionParser.Expr_in_bracketsContext) {
        if (ctx.childCount != 3)
            throw IllegalStateException("Expected exactly 3 children, but got ${ctx.childCount}\n" +
                    "\tinput data - ${ctx.text}")
        result = ExpressionBuilder.build(ctx.getChild(1))
    }

    override fun enterNumber(ctx: ExpressionParser.NumberContext) {
        result = StringExpressionGraph(ctx.text)
    }

    override fun enterLexem(ctx: ExpressionParser.LexemContext) {
        result = StringExpressionGraph(ctx.text)
    }

    override fun enterRelops(ctx: ExpressionParser.RelopsContext) {
        result = StringExpressionGraph(ctx.text)
    }

    override fun enterLowest_priority(ctx: ExpressionParser.Lowest_priorityContext) {
        result = StringExpressionGraph(ctx.text)
    }

    override fun enterLow_priority(ctx: ExpressionParser.Low_priorityContext) {
        result = StringExpressionGraph(ctx.text)
    }

    override fun enterMiddle_priority(ctx: ExpressionParser.Middle_priorityContext) {
        result = StringExpressionGraph(ctx.text)
    }

    override fun enterUnary_left(ctx: ExpressionParser.Unary_leftContext) {
        result = StringExpressionGraph(ctx.text)
    }

    override fun enterUnary_right(ctx: ExpressionParser.Unary_rightContext) {
        result = StringExpressionGraph(ctx.text)
    }

}

fun main() {
    ExpressionBuilder().scanForExpressions("")
    println()
}