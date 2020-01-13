package com.compute.graph.operations.builders.contexts

import com.compute.graph.operations.interfaces.arguments.ComputationArgs
import com.compute.graph.operations.objects.MathObject
import com.compute.graph.operations.objects.Tensor
import com.compute.graph.operations.objects.arguments.ComputationArgsImpl
import com.compute.graph.operations.objects.operands.Variable
import com.compute.graph.operations.objects.types.ScalarConstant

/**
 * @Author: evgeny
 * @Date: 2019-06-23
 */
open class ArgsBuilderContext {
    private val values = hashMapOf<String, MathObject>()

    infix fun Variable.to(value: Number) {
        values[this.name] = ScalarConstant(value.toDouble())
    }

    infix fun String.to(value: Number) {
        values[this] = ScalarConstant(value.toDouble())
    }

    fun buildArgs(): ComputationArgs =
        ComputationArgsImpl(values)
}