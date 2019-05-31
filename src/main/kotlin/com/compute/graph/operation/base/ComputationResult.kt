package com.compute.graph.operation.base

import org.apache.commons.math3.linear.MatrixUtils
import org.apache.commons.math3.linear.RealMatrix
import org.apache.commons.math3.linear.RealVector

sealed class ComputationResult

// todo mb its better to create lists
class ScalarComputationResult(
        var value: Double
) : ComputationResult()

class VectorComputationResult(
        var value: RealVector
) : ComputationResult()

class MatrixComputationResult(
        var value: RealMatrix
) : ComputationResult()

class MultipleResult(
        /**
         * Function name mapped to diff result
         */
        val map: MutableMap<String, ComputationResult>
) : ComputationResult()
