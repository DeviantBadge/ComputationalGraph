package com.compute.graph.operation.objects.arguments

import com.compute.graph.operation.interfaces.ExpressionArgs

class ScalarArguments(
        private val map: Map<String, Double>)
    : ExpressionArgs {

    override val names: List<String>
        get() = map.keys.toList()

    override fun get(varName: String): Double? {
        return map[varName]
    }
}