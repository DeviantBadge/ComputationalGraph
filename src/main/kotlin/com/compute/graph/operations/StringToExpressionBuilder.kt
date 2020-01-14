package com.compute.graph.operations

import com.compute.graph.ThrowingErrorListener
import com.compute.graph.antlr.ExpressionBaseListener
import com.compute.graph.antlr.ExpressionLexer
import com.compute.graph.antlr.ExpressionParser
import com.compute.graph.operations.annotations.*
import com.compute.graph.operations.annotations.Function
import com.compute.graph.operations.builders.ConstantBuilder
import com.compute.graph.operations.builders.FunctionBuilder
import com.compute.graph.operations.builders.OperatorBuilder
import com.compute.graph.operations.builders.VariableBuilder
import com.compute.graph.operations.builders.contexts.ArgsBuilder
import com.compute.graph.operations.dsl.operations.binary.operators.times
import com.compute.graph.operations.dsl.operations.unary.functions.cos
import com.compute.graph.operations.dsl.operations.unary.functions.sin
import com.compute.graph.operations.dsl.operations.unary.operators.unaryMinus
import com.compute.graph.operations.objects.MathExpression
import com.compute.graph.operations.objects.MathObject
import com.compute.graph.operations.objects.Variable
import com.compute.graph.operations.visitors.differentiation.BackwardDifferentialVisitor
import com.compute.graph.operations.visitors.differentiation.ForwardDifferentialVisitor
import com.compute.graph.operations.visitors.execution.ComputationVisitor
import io.github.classgraph.ClassGraph
import io.github.classgraph.ClassInfo
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.tree.ErrorNode
import org.antlr.v4.runtime.tree.ParseTree
import org.antlr.v4.runtime.tree.RuleNode
import org.antlr.v4.runtime.tree.TerminalNode
import kotlin.math.cos as cos_double
import kotlin.math.sin as sin_double

internal object StringToExpressionBuilder {
    init {
        scanForExpressions()
    }

    fun build(string: String): MathExpression {
        val lexer = ExpressionLexer(CharStreams.fromString(string))
        lexer.addErrorListener(ThrowingErrorListener.INSTANCE)
        val tokens = CommonTokenStream(lexer)
        val parser = ExpressionParser(tokens)
        parser.addErrorListener(ThrowingErrorListener.INSTANCE)
        return build(parser.expression())
    }

    internal fun build(parseTree: ParseTree): MathExpression {
        return ExpressionContext().build(parseTree)
    }

    fun scanForExpressions(vararg packages: String) {
        val packagesList = if (packages.isEmpty())
            listOf("")
        else
            packages.toList()
        scanForExpressions(packagesList)
    }

    fun scanForExpressions(packages: List<String>) {
        scanPackages(
            packages = packages,
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
                    ConstantBuilder.register(it, res)
                }
        }
        if (clazz.hasAnnotation(VariableDeclaration::class.qualifiedName)) {
            // todo what to do here
        }
    }
}

internal class ExpressionContext {
    val variableBuilder = VariableBuilder()

    fun build(parseTree: ParseTree): MathExpression {
        if (parseTree is ErrorNode || parseTree is TerminalNode) {
            throw java.lang.IllegalStateException("There was unexpected error in parsed tree - ${parseTree.text}")
        }

        val ruleNode = parseTree as RuleNode
        val ctx = ruleNode.ruleContext as ParserRuleContext
        val listener = ExpressionGraphListener(this)
        ctx.enterRule(listener)
        return listener.result
    }
}

internal class ExpressionGraphListener(
    private val expressionContext: ExpressionContext
) : ExpressionBaseListener() {
    lateinit var result: MathExpression

    override fun enterEquation(ctx: ExpressionParser.EquationContext) {
        TODO()
    }

    override fun enterExpression(ctx: ExpressionParser.ExpressionContext) {
        if (ctx.childCount == 1) {
            result = expressionContext.build(ctx.getChild(0))
        } else {
            var expr: MathExpression = expressionContext.build(ctx.getChild(0))

            for (i in 1 until ctx.childCount step 2) {
                val child = expressionContext.build(ctx.getChild(i + 1))
                expr = OperatorBuilder.buildBinaryOperation(ctx.getChild(i).text, expr, child)
            }
            result = expr
        }
    }

    override fun enterTerm(ctx: ExpressionParser.TermContext) {
        if (ctx.childCount == 1) {
            result = expressionContext.build(ctx.getChild(0))
        } else {
            var term: MathExpression = expressionContext.build(ctx.getChild(0))

            var i = 1
            while (i < ctx.childCount) {
                val child = expressionContext.build(ctx.getChild(i + 1))
                when (ctx.getChild(i).text) {
                    "/", "*" -> {
                        term = OperatorBuilder.buildBinaryOperation(ctx.getChild(i).text, term, child)
                        i += 2
                    }
                    else -> {
                        term = OperatorBuilder.buildBinaryOperation("*", term, child)
                        i++
                    }
                }
            }

            result = term

        }
    }

    override fun enterFactor(ctx: ExpressionParser.FactorContext) {
        if (ctx.childCount == 1) {
            result = expressionContext.build(ctx.getChild(0))
        } else {
            var factor: MathExpression = expressionContext.build(ctx.getChild(ctx.childCount - 1))

            for (i in ctx.childCount - 2 downTo 1 step 2) {
                val child = expressionContext.build(ctx.getChild(i - 1))
                // here it would be '^'
                // todo test it
                factor = OperatorBuilder.buildBinaryOperation(ctx.getChild(i).text, child, factor)
            }
            result = factor
        }
    }

    override fun enterSigned_composed_atom(ctx: ExpressionParser.Signed_composed_atomContext) {
        when {
            ctx.childCount == 1 ->
                result = expressionContext.build(ctx.getChild(0))
            ctx.childCount == 2 ->
                result = OperatorBuilder.buildUnaryOperation(ctx.getChild(0).text, expressionContext.build(ctx.getChild(1)))
            else -> {
                throw IllegalStateException("Unexpected child amount - ${ctx.childCount} while parsing ${ctx.text}")
            }
        }
    }

    // todo ended here
    override fun enterComposed_atom(ctx: ExpressionParser.Composed_atomContext) {
        result = when {
            ctx.childCount == 1 ->
                expressionContext.build(ctx.getChild(0))
            ctx.childCount == 2 -> {
                val funName = ctx.getChild(0).text
                if (FunctionBuilder.isRegistered(funName))
                    FunctionBuilder.buildUnaryOperation(funName, expressionContext.build(ctx.getChild(1)))
                else
                    OperatorBuilder.buildBinaryOperation("*",
                        expressionContext.build(ctx.getChild(0)),
                        expressionContext.build(ctx.getChild(1)))
            }
            else ->
                throw IllegalStateException("Unexpected child amount - ${ctx.childCount} while parsing ${ctx.text}")
        }
    }

    override fun enterAtom(ctx: ExpressionParser.AtomContext) {
        result = when {
            ctx.childCount == 1 ->
                expressionContext.build(ctx.getChild(0))
            ctx.childCount == 2 -> {
                OperatorBuilder.buildUnaryOperation(
                    ctx.getChild(1).text,
                    expressionContext.build(ctx.getChild(0))
                )
            }
            else ->
                throw IllegalStateException("Unexpected child amount - ${ctx.childCount} while parsing ${ctx.text}")
        }
    }

    // todo if i will implement comma this will be wrong
    override fun enterExpr_in_brackets(ctx: ExpressionParser.Expr_in_bracketsContext) {
        result = expressionContext.build(ctx.getChild(1))
    }

    override fun enterNumber(ctx: ExpressionParser.NumberContext) {
        result = ConstantBuilder.buildIndependentOperand(ctx.text)
    }

    override fun enterLexem(ctx: ExpressionParser.LexemContext) {
        result = if (ConstantBuilder.isRegistered(ctx.text))
            ConstantBuilder.buildIndependentOperand(ctx.text)
        else
            expressionContext.variableBuilder.buildIndependentOperand(ctx.text)
    }

    override fun enterRelops(ctx: ExpressionParser.RelopsContext) {
        TODO()
    }

    override fun enterLowest_priority(ctx: ExpressionParser.Lowest_priorityContext) {
        TODO()
    }

    override fun enterLow_priority(ctx: ExpressionParser.Low_priorityContext) {
        TODO()
    }

    override fun enterMiddle_priority(ctx: ExpressionParser.Middle_priorityContext) {
        TODO()
    }

    override fun enterUnary_left(ctx: ExpressionParser.Unary_leftContext) {
        TODO()
    }

    override fun enterUnary_right(ctx: ExpressionParser.Unary_rightContext) {
        TODO()
    }
}

fun main() {
    val x = Variable("x")
    val y = Variable("y")
    val a: MathObject = -sin(x) * cos(y)
    val computer = ComputationVisitor(a)
    val differentiatorF = ForwardDifferentialVisitor(a)
    val differentiatorB = BackwardDifferentialVisitor(a)

    println(computer.compute(ArgsBuilder.buildArgs { x to 10; y to 20 }))
    println(-sin_double(10.0) * cos_double(20.0))

    println(differentiatorF.compute(ArgsBuilder.buildArgs { x to 10; y to 20 }))
    println(differentiatorB.compute(ArgsBuilder.buildArgs { x to 10; y to 20 }))
    println(-cos_double(10.0) * cos_double(20.0))
    println(sin_double(10.0) * sin_double(20.0))
}
