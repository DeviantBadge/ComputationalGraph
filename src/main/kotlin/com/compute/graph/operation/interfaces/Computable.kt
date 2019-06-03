package com.compute.graph.operation.interfaces

import com.compute.graph.operation.base.ComputationResult

interface Computable {
    fun compute(context: ExpressionContext): ComputationResult
}