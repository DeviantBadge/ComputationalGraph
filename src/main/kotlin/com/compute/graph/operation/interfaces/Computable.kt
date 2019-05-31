package com.compute.graph.operation.interfaces

import com.compute.graph.operation.base.ComputationResult

interface Computable {
    fun compute(args: ExpressionArgs): ComputationResult
}