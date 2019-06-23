package com.compute.graph.operations.objects.arguments

import com.compute.graph.operations.base.ComputationResult
import com.compute.graph.operations.interfaces.Expression
import com.compute.graph.operations.interfaces.ExpressionContext

class ComputationContext(
    arguments: Map<String, ComputationResult>,
    private val computedExpressions: MutableMap<Expression, ComputationResult> = mutableMapOf()
) : ComputationArgs(arguments),
    ExpressionContext {

    override operator fun get(
        expression: Expression
    ): ComputationResult? =
        computedExpressions[expression]

    override operator fun set(
        expression: Expression,
        result: ComputationResult
    ): ComputationResult? =
        computedExpressions.put(expression, result)

    override fun toString(): String {
        return computedExpressions.entries.joinToString(prefix = "Cached expressions List:\n", separator = "\n") {
                "%-5s  ->   %s".format(it.key, it.value.toString())
            } + "\n\n" + super.toString()
    }
}