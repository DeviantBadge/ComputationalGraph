package com.compute.graph.operation.interfaces

import com.compute.graph.graph.DirectedGraph

// todo create builder for it
interface ExpressionArgs {
    operator fun get(varName: String): Double?
    val names: List<String>
}
