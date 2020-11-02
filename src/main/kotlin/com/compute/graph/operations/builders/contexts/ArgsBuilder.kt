package com.compute.graph.operations.builders.contexts

import com.compute.graph.operations.interfaces.arguments.ComputationArgs
import com.compute.graph.operations.objects.MathObject
import com.compute.graph.operations.objects.Variable
import com.compute.graph.operations.objects.arguments.ComputationArgsImpl
import com.compute.graph.operations.objects.types.ScalarConstant

/**
 * @Author: evgeny
 * @Date: 13/01/2020
 */
object ArgsBuilder {
    open class ArgsBuilderContext (
        private val values: MutableMap<String, MathObject> = hashMapOf()
    ){
        infix fun Variable.to(value: Number) {
            values[this.name] = ScalarConstant(value.toDouble())
        }

        infix fun String.to(value: Number) {
            values[this] = ScalarConstant(value.toDouble())
        }

        infix fun Variable.to(value: MathObject) {
            values[this.name] = value
        }

        infix fun String.to(value: MathObject) {
            values[this] = value
        }

        fun buildArgs(): ComputationArgs =
            ComputationArgsImpl(values)
    }

    fun buildArgs(initedValues: MutableMap<String, MathObject> = mutableMapOf(), init: ArgsBuilderContext.() -> Unit) =
        ArgsBuilderContext(initedValues).also { it.init() }.buildArgs()
}

