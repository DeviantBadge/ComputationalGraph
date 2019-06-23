package com.compute.graph.operations.builders.contexts

import com.compute.graph.operations.base.ComputationResult
import com.compute.graph.operations.base.MatrixComputationResult
import com.compute.graph.operations.base.ScalarComputationResult
import com.compute.graph.operations.base.VectorComputationResult
import com.compute.graph.operations.interfaces.ExpressionArgs
import com.compute.graph.operations.objects.arguments.ComputationArgs
import org.apache.commons.math3.linear.RealMatrix
import org.apache.commons.math3.linear.RealVector

/**
 * @Author: evgeny
 * @Date: 2019-06-23
 */
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