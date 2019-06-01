package com.compute.graph.graph

import com.compute.graph.ThrowingErrorListener
import com.compute.graph.antlr.ExpressionBaseListener
import com.compute.graph.antlr.ExpressionLexer
import com.compute.graph.antlr.ExpressionParser
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.tree.*
import java.lang.IllegalStateException

class StringExpressionGraph(
    override var value: String = "",
    override val parents: MutableList<StringExpressionGraph> = mutableListOf(),
    override val children: MutableList<StringExpressionGraph> = mutableListOf()) :
    DirectedGraphNode<String> {

    init {
        children.forEach {
            it.addParent(this)
        }
    }

    constructor(value: String = "",
                parent: StringExpressionGraph,
                children: MutableList<StringExpressionGraph> = mutableListOf()) :
        this(value, mutableListOf(parent), children)

    fun addChild(child: StringExpressionGraph) {
        children.add(child)
        child.addParent(this)
    }

    fun addParent(parent: StringExpressionGraph) {
        if (!parents.contains(parent))
            parents.add(parent)
    }
}

object StringExpressionGraphBuilder {
    fun build(string: String): StringExpressionGraph {
        val lexer = ExpressionLexer(CharStreams.fromString(string))
        lexer.addErrorListener(ThrowingErrorListener.INSTANCE)
        val tokens = CommonTokenStream(lexer)
        val parser = ExpressionParser(tokens)
        parser.addErrorListener(ThrowingErrorListener.INSTANCE)
        return build(parser.expression())
    }

    internal fun build(parseTree: ParseTree): StringExpressionGraph {
        if (parseTree is ErrorNode) {
            throw IllegalStateException("There was some error node in parsed tree - ${parseTree.text}")
        } else if (parseTree is TerminalNode) {
            return StringExpressionGraph(parseTree.text)
        }

        val r = parseTree as RuleNode
        val ctx = r.ruleContext as ParserRuleContext
        val listener = StringExpressionGraphListener()
        ctx.enterRule(listener)
        return listener.result
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
                if (subtract.size == 1)
                    newResult.addChild(subtract.first())
                else
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
    val graph = StringExpressionGraphBuilder.build("-sin 3! * 4 ^ (2 + 2)! ^ 2 * x1 + 3y + 3 - 2")
    println(null)
}