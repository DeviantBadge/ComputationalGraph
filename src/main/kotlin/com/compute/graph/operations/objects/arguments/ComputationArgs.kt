package com.compute.graph.operations.objects.arguments

import com.compute.graph.operations.base.ComputationResult
import com.compute.graph.operations.interfaces.ExpressionArgs

open class ComputationArgs(
    private val arguments: Map<String, ComputationResult>)
    : ExpressionArgs {

    override val names: List<String>
        get() = arguments.keys.toList()

    override fun get(varName: String): ComputationResult? {
        return arguments[varName]
    }

    override fun toString(): String {
        return arguments.entries.joinToString(prefix = "Arguments List:\n", separator = "\n") {
            "%-5s  ->   %s".format(it.key, it.value.toString())
        }
    }
}