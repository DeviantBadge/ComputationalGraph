package com.compute.graph.operations.interfaces

import com.compute.graph.operations.base.ComputationResult

interface Computable {
    fun compute(context: ExpressionContext): ComputationResult
}
