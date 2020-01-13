package com.compute.graph.operations.dsl.objects

import com.compute.graph.operations.objects.AlgebraicShape
import com.compute.graph.operations.objects.AlgebraicType
import com.compute.graph.operations.objects.Scalar
import com.compute.graph.operations.objects.Tensor
import com.compute.graph.operations.objects.types.ScalarConstant
import com.compute.graph.operations.objects.types.TensorImpl
import com.compute.graph.util.extensions.isVector
import com.compute.graph.util.extensions.toTensor
import com.compute.graph.util.extensions.toVector
import java.util.*

/**
 * @Author: evgeny
 * @Date: 2019-08-05
 */
fun matScalar(value: Number): Scalar =
    ScalarConstant(value)


fun matVector(vararg values: Number): Tensor =
    values.asIterable().toVector()

inline fun matVector(dimension: Int, init: (index: Int) -> Number): Tensor =
    List(dimension, init).toVector()

fun matVector(dimension: Int, initialValue: Number = 0): Tensor =
    matVector(dimension) { initialValue }

fun matZeros(dimension: Int) =
    matVector(dimension, 0)

fun matOnes(dimension: Int) =
    matVector(dimension, 1)


fun matMatrix(vararg values: Tensor): Tensor {
    if (values.any { !it.isVector() }) {
        throw IllegalArgumentException("Failed to create matrix, argument rank should be equal to one")
    }
    return TensorImpl(*values)
}

fun matMatrix(dimension: Int, init: (Int) -> Tensor): Tensor =
    List(dimension) {
        val row = init(it)
        if (!row.isVector()) {
            throw IllegalArgumentException("Failed to create matrix, argument rank should be equal to one")
        }
        row
    }.toTensor()

inline fun matMatrix(rows: Int, cols: Int, init: (rowNum: Int, colNum: Int) -> Number): Tensor =
    List(rows) { rowNum ->
        List(cols) { colNum ->
            init(rowNum, colNum)
        }.toVector()
    }.toTensor()

fun matMatrix(firstDim: Int, secondDim: Int, initialValue: Number): Tensor =
    matMatrix(firstDim, secondDim) { _, _ -> initialValue }

fun matZeros(firstDim: Int, secondDim: Int): Tensor =
    matMatrix(firstDim, secondDim, 0)

fun matOnes(firstDim: Int, secondDim: Int): Tensor =
    matMatrix(firstDim, secondDim, 1)


fun matTensor(vararg dimensions: Int, init: (List<Int>) -> Number): Tensor =
    matTensorRec(LinkedList(dimensions.toList()), Stack(), init)

private fun matTensorRec(
    dimensions: LinkedList<Int>,
    parameters: Stack<Int>,
    init: (List<Int>) -> Number
): Tensor {
    if (dimensions.size == 1) {
        return List(dimensions.poll()) {
            parameters.add(it)
            init(parameters).also {
                parameters.removeAt(parameters.size - 1)
            }
        }.also { dimensions.addFirst(it.size) }
            .toVector()
    }
    return List(dimensions.poll()) {
        parameters.add(it)
        matTensorRec(dimensions, parameters, init).also {
            parameters.removeAt(parameters.size - 1)
        }
    }.also { dimensions.addFirst(it.size) }
        .toTensor()
}

fun matTensorZeros(vararg dimensions: Int): Tensor =
    matTensor(*dimensions) { 0 }

fun matTensorOnes(vararg dimensions: Int): Tensor =
    matTensor(*dimensions) { 1 }
