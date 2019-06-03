package com.compute.graph.operation.interfaces

import com.compute.graph.operation.base.MultipleResult

interface Differentiable {
    // todo create also another differential context
    fun differentiateForward(args: ExpressionArgs): MultipleResult

    fun differentiateBackward(args: ExpressionArgs): MultipleResult

    fun differentiate(args: ExpressionArgs): Expression {
        TODO()
    }

    fun differentiate(
        args: ExpressionArgs,
        varName: String
    ): Expression {
        TODO()
    }
}
