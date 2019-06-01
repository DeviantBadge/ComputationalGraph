package com.compute.graph.operation.objects.arguments

import com.compute.graph.operation.base.ComputationResult
import com.compute.graph.operation.base.MathExpression

class ComputationContext(
    arguments: Map<String, ComputationResult>,
    private val computedExpressions: MutableMap<MathExpression, ComputationResult> = mutableMapOf()
) : Arguments(arguments) {

    operator fun get(
        expression: MathExpression
    ): ComputationResult? =
        computedExpressions[expression]

    operator fun set(
        expression: MathExpression,
        result: ComputationResult
    ): ComputationResult? =
        computedExpressions.put(expression, result)
}