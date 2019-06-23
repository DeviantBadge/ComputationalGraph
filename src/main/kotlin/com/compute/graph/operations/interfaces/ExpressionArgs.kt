package com.compute.graph.operations.interfaces

import com.compute.graph.operations.base.ComputationResult

// todo create builder for it
interface ExpressionArgs {
    operator fun get(varName: String): ComputationResult?
    val names: List<String>

    override fun toString(): String
}
