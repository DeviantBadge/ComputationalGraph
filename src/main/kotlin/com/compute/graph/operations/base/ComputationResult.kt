package com.compute.graph.operations.base

import org.apache.commons.math3.linear.RealMatrix
import org.apache.commons.math3.linear.RealVector

sealed class ComputationResult {
    abstract override fun toString(): String
}

// todo mb its better to create lists
class ScalarComputationResult(
    val value: Double
) : ComputationResult() {

    override fun toString(): String = value.toString()
}

class VectorComputationResult(
    val value: RealVector
) : ComputationResult() {

    override fun toString(): String = value.toString()
}

class MatrixComputationResult(
    val value: RealMatrix
) : ComputationResult() {

    override fun toString(): String = value.toString()
}

class ExpressionComputationResult(
    val value: MathExpression
) : ComputationResult() {

    override fun toString(): String = value.toString()
}

// todo may be make it immutable?
class MultipleResult(
    /**
     * Function name mapped to diff result
     */
    val results: MutableMap<String, ComputationResult>
) : ComputationResult() {

    override fun toString(): String = results.entries.joinToString(prefix = "All multiple values:\n", separator = "\n") {
        "%-5s  ->   %s".format(it.key, it.value.toString())
    }
}
