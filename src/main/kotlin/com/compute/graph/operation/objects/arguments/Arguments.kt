package com.compute.graph.operation.objects.arguments

import com.compute.graph.operation.base.ComputationResult
import com.compute.graph.operation.interfaces.ExpressionArgs

open class Arguments(
    private val arguments: Map<String, ComputationResult>)
    : ExpressionArgs {

    override val names: List<String>
        get() = arguments.keys.toList()

    override fun get(varName: String): ComputationResult? {
        return arguments[varName]
    }
}