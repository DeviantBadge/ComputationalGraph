package com.compute.graph.operation

import com.compute.graph.antlr.ExpressionBaseListener
import com.compute.graph.antlr.ExpressionParser
import com.compute.graph.graph.StringExpressionGraph
import com.compute.graph.graph.StringExpressionGraphBuilder
import com.compute.graph.operation.annotations.ExpressionGraphPart
import com.compute.graph.operation.base.TransformableExpression
import com.compute.graph.operation.objects.variables.ScalarVariable
import com.compute.graph.operation.objects.arguments.ScalarArguments
import com.compute.graph.operation.objects.constants.ScalarConstant
import com.compute.graph.operation.objects.functions.SinFunction
import com.compute.graph.operation.objects.operators.DivOp
import com.compute.graph.operation.objects.operators.MulOp
import com.compute.graph.operation.objects.operators.SubOp
import com.compute.graph.operation.objects.operators.SumOp
import com.compute.graph.util.PackageExprScanner
import io.github.classgraph.ClassInfo
import org.antlr.v4.runtime.tree.*
import java.lang.IllegalStateException

class ExpressionBuilder {
    init {

    }

    private val variables: MutableMap<String, ScalarVariable> = hashMapOf()

    // todo automate it - spring context in operators package
    val operators = mutableMapOf(
            "+" to ::SumOp,
            "-" to ::SubOp,
            "/" to ::DivOp,
            "*" to ::MulOp
    )

    // todo automate it - spring context in functions package
    val functions = mutableMapOf(
            "sin" to ::SinFunction
    )

    fun build(string: String): TransformableExpression {
        return build(StringExpressionGraphBuilder.build(string))
    }

    internal fun build(parseTree: ParseTree): TransformableExpression {
        return build(StringExpressionGraphBuilder.build(parseTree))
    }

    // todo checks
    fun build(stringGraph: StringExpressionGraph): TransformableExpression {
        val res = when {
            stringGraph.value in operators ->
                operators.getValue(stringGraph.value).invoke(build(stringGraph.children[0]), build(stringGraph.children[1]))
            stringGraph.value in functions ->
                functions.getValue(stringGraph.value).invoke(build(stringGraph.children[0]))
            stringGraph.value.toDoubleOrNull() != null ->
                ScalarConstant(stringGraph.value.toDouble())
            stringGraph.value in variables ->
                variables.getValue(stringGraph.value)
            else -> {
                ScalarVariable(stringGraph.value).also {
                    variables[stringGraph.value] = it
                }
            }
        }
        return res
    }

    fun scanForOperands(packages: List<String>) {
        PackageExprScanner.scanPackages(
                packages = listOf(""),
                annotations = listOf(ExpressionGraphPart::class.java.canonicalName),
                extendsClasses = listOf(TransformableExpression::class.java.canonicalName)
        ).forEach(this::processClass)
    }

    private fun processClass(clazz: ClassInfo) {
        if (clazz.hasAnnotation(Function::class.java.canonicalName))

    }
}

class StringExpressionGraphListener : ExpressionBaseListener() {
    lateinit var result: StringExpressionGraph

    override fun enterEquation(ctx: ExpressionParser.EquationContext) {
        if (ctx.childCount != 3)
            throw IllegalStateException("Expected exactly 3 children, but got ${ctx.childCount}\n" +
                    "\tinput data - ${ctx.text}")
        result = StringExpressionGraph(ctx.getChild(1).text)
        result.addChild(StringExpressionGraphBuilder.build(ctx.getChild(0)))
        result.addChild(StringExpressionGraphBuilder.build(ctx.getChild(2)))
    }

    override fun enterExpression(ctx: ExpressionParser.ExpressionContext) {
        if (ctx.childCount == 1) {
            result = StringExpressionGraphBuilder.build(ctx.getChild(0))
        } else {
            val subtract = mutableListOf<StringExpressionGraph>()
            result = StringExpressionGraph("+")
            result.addChild(StringExpressionGraphBuilder.build(ctx.getChild(0)))

            for (i in 1 until ctx.childCount step 2) {
                val child = StringExpressionGraphBuilder.build(ctx.getChild(i + 1))
                if (ctx.getChild(i).text == "-") {
                    subtract += child
                } else {
                    result.addChild(child)
                }
            }
            if (subtract.isNotEmpty()) {
                val newResult = StringExpressionGraph("-")
                newResult.addChild(result)
                newResult.addChild(StringExpressionGraph("+", newResult, subtract))
                result = newResult
            }
        }
    }

    override fun enterTerm(ctx: ExpressionParser.TermContext) {
        if (ctx.childCount == 1) {
            result = StringExpressionGraphBuilder.build(ctx.getChild(0))
        } else {
            val divide = mutableListOf<StringExpressionGraph>()
            result = StringExpressionGraph("*")
            result.addChild(StringExpressionGraphBuilder.build(ctx.getChild(0)))

            var i = 1
            while (i < ctx.childCount) {
                when {
                    ctx.getChild(i).text == "/" -> {
                        if (i + 1 >= ctx.childCount)
                            throw IllegalStateException("Unexpected last character - / in ${ctx.text}")
                        divide += StringExpressionGraphBuilder.build(ctx.getChild(i + 1))
                        i += 2
                    }
                    ctx.getChild(i).text == "*" -> {
                        if (i + 1 >= ctx.childCount)
                            throw IllegalStateException("Unexpected last character - * in ${ctx.text}")
                        result.addChild(StringExpressionGraphBuilder.build(ctx.getChild(i + 1)))
                        i += 2
                    }
                    else -> {
                        result.addChild(StringExpressionGraphBuilder.build(ctx.getChild(i)))
                        i++
                    }
                }
            }
            if (divide.isNotEmpty()) {
                val newResult = StringExpressionGraph("/")
                newResult.addChild(result)
                newResult.addChild(StringExpressionGraph("*", newResult, divide))
                result = newResult
            }
        }
    }

    override fun enterFactor(ctx: ExpressionParser.FactorContext) {
        if (ctx.childCount == 1) {
            result = StringExpressionGraphBuilder.build(ctx.getChild(0))
        } else {
            result = StringExpressionGraph("^")
            result.addChild(StringExpressionGraphBuilder.build(ctx.getChild(0)))

            for (i in 2 until ctx.childCount step 2) {
                result.addChild(StringExpressionGraphBuilder.build(ctx.getChild(i)))
            }
        }
    }

    override fun enterSigned_composed_atom(ctx: ExpressionParser.Signed_composed_atomContext) {
        result = StringExpressionGraphBuilder.build(ctx.getChild(0))
        when {
            ctx.childCount == 1 ->
                return
            ctx.childCount == 2 ->
                result.addChild(StringExpressionGraphBuilder.build(ctx.getChild(1)))
            else -> {
                throw IllegalStateException("Unexpected child amount - ${ctx.childCount} while parsing ${ctx.text}")
            }
        }
    }

    // todo ended here
    override fun enterComposed_atom(ctx: ExpressionParser.Composed_atomContext) {
        result = StringExpressionGraphBuilder.build(ctx.getChild(0))
        when {
            ctx.childCount == 1 ->
                return
            ctx.childCount == 2 ->
                result.addChild(StringExpressionGraphBuilder.build(ctx.getChild(1)))
            else -> {
                throw IllegalStateException("Unexpected child amount - ${ctx.childCount} while parsing ${ctx.text}")
            }
        }
    }

    override fun enterAtom(ctx: ExpressionParser.AtomContext) {
        if (ctx.childCount == 1) {
            result = StringExpressionGraphBuilder.build(ctx.getChild(0))
        } else {
            result = StringExpressionGraphBuilder.build(ctx.getChild(1))
            result.addChild(StringExpressionGraphBuilder.build(ctx.getChild(0)))
        }
    }

    override fun enterExpr_in_brackets(ctx: ExpressionParser.Expr_in_bracketsContext) {
        if (ctx.childCount != 3)
            throw IllegalStateException("Expected exactly 3 children, but got ${ctx.childCount}\n" +
                    "\tinput data - ${ctx.text}")
        result = StringExpressionGraphBuilder.build(ctx.getChild(1))
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
    val graph = ExpressionBuilder().build("a*x + 22")
    val args = ScalarArguments(mutableMapOf (
            "a" to 22.toDouble(),
            "x" to 3.toDouble()))
    println(graph.compute(args))
    println(null)
}