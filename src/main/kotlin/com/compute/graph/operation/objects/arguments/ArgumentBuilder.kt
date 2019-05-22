package com.compute.graph.operation.objects.arguments

import com.compute.graph.operation.interfaces.ExpressionArgs

/**
 * @Author: evgeny.vorobyev
 * @Since: 1.0
 * @Version:1.0,Date:2019-05-21
 */
object ArgumentBuilder {
    fun build(init: ArgumentContext.() -> Unit): ExpressionArgs =
            ArgumentContext().apply(init).build()
}

class ArgumentContext {
    private val scalarValues = hashMapOf<String, Double>()

    infix fun String.to(value: Double) {
        scalarValues[this] = value
    }

    fun build(): ExpressionArgs =
            ScalarArguments(scalarValues)
}