package com.compute.graph.operations.objects.arguments

import com.compute.graph.operations.interfaces.arguments.ComputationArgs
import com.compute.graph.operations.objects.MathObject
import com.compute.graph.operations.objects.operands.Variable

class ComputationArgsImpl(
    val arguments: Map<String, MathObject>
) : ComputationArgs {
    override fun get(variable: Variable): MathObject? =
        arguments[variable.name]

    override val names: List<String>
        get() = arguments.keys.toList()

    override fun toString(): String {
        return arguments.entries.joinToString(prefix = "Arguments List:\n", separator = "\n") {
            "%-5s  ->   %s".format(it.key, it.value.toString())
        }
    }
}