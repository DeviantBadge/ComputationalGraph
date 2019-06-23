package com.compute.graph.operations.interfaces

import com.compute.graph.operations.base.ComputationResult

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
