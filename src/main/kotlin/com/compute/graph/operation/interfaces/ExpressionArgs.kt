package com.compute.graph.operation.interfaces

import com.compute.graph.graph.DirectedGraph
import com.compute.graph.operation.base.ComputationResult

// todo create builder for it
interface ExpressionArgs {
    operator fun get(varName: String): ComputationResult?
    val names: List<String>
}
