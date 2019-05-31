package com.compute.graph.operation.objects.arguments

import com.compute.graph.operation.base.ComputationResult
import com.compute.graph.operation.interfaces.ExpressionArgs

class Arguments(
        private val map: Map<String, ComputationResult>)
    : ExpressionArgs {

    override val names: List<String>
        get() = map.keys.toList()

    override fun get(varName: String): ComputationResult? {
        return map[varName]
    }
}