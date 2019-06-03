package com.compute.graph.operation.interfaces

import com.compute.graph.operation.base.ComputationResult

// todo create builder for it
interface ExpressionContext: ExpressionArgs {
    operator fun get(
        expression: Expression
    ): ComputationResult?

    operator fun set(
        expression: Expression,
        result: ComputationResult
    ): ComputationResult?
}
