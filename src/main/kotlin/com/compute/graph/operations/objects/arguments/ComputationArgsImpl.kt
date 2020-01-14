package com.compute.graph.operations.objects.arguments

import com.compute.graph.operations.interfaces.arguments.ComputationArgs
import com.compute.graph.operations.objects.MathObject

class ComputationArgsImpl(
    private val arguments: Map<String, MathObject>
) : ComputationArgs {
    override fun get(variableName: String): MathObject? =
        arguments[variableName]

    override val names: List<String>
        get() = arguments.keys.toList()

    override fun toString(): String {
        return arguments.entries.joinToString(prefix = "Arguments List:\n", separator = "\n") {
            "%-5s  ->   %s".format(it.key, it.value.toString())
        }
    }
}