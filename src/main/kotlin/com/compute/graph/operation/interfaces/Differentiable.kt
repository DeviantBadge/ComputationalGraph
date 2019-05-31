package com.compute.graph.operation.interfaces

import com.compute.graph.operation.base.MultipleResult

interface Differentiable {
    fun differentiateForward(args: ExpressionArgs): MultipleResult

    fun differentiateBackward(args: ExpressionArgs): MultipleResult
}
