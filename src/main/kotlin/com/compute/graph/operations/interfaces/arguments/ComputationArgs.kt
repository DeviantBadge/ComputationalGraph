package com.compute.graph.operations.interfaces.arguments

import com.compute.graph.operations.objects.MathObject

// todo create builder for it
interface ComputationArgs {
    operator fun get(variableName: String): MathObject?

    val names: List<String>

    override fun toString(): String
}
