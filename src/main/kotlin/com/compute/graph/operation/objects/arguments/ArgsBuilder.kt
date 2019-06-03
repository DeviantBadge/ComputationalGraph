package com.compute.graph.operation.objects.arguments

import com.compute.graph.operation.base.ComputationResult
import com.compute.graph.operation.base.MatrixComputationResult
import com.compute.graph.operation.base.ScalarComputationResult
import com.compute.graph.operation.base.VectorComputationResult
import com.compute.graph.operation.interfaces.ExpressionArgs
import com.compute.graph.operation.interfaces.ExpressionContext
import org.apache.commons.math3.linear.RealMatrix
import org.apache.commons.math3.linear.RealVector

/**
 * @Author: evgeny
 * @Since: 1.0
 * @Version:1.0,Date:2019-05-21
 */
object ArgsBuilder {
    fun buildArgs(init: ArgsBuilderContext.() -> Unit): ExpressionArgs =
        ArgsBuilderContext().apply(init).buildArgs()

    fun buildContext(init: ContextBuilderContext.() -> Unit): ExpressionContext =
        ContextBuilderContext().apply(init).buildContext()
}

class ContextBuilderContext: ArgsBuilderContext() {

    fun buildContext(): ExpressionContext =
        ComputationContext(values)
}

open class ArgsBuilderContext {
    val values = hashMapOf<String, ComputationResult>()

    infix fun String.to(value: Double) {
        values[this] = ScalarComputationResult(value)
    }

    infix fun String.to(value: Int) {
        values[this] = ScalarComputationResult(value.toDouble())
    }

    infix fun String.to(value: RealVector) {
        values[this] = VectorComputationResult(value)
    }

    infix fun String.to(value: RealMatrix) {
        values[this] = MatrixComputationResult(value)
    }

    fun buildArgs(): ExpressionArgs =
        ComputationArgs(values)
}