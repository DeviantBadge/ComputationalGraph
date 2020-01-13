package com.compute.graph.operations.interfaces.arguments

import com.compute.graph.operations.objects.MathObject
import com.compute.graph.operations.objects.Tensor
import com.compute.graph.operations.objects.operands.Variable

// todo create builder for it
interface ComputationArgs {
    operator fun get(variable: Variable): MathObject?

    val names: List<String>

    override fun toString(): String
}
