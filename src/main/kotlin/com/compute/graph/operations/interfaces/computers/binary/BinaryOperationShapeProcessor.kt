package com.compute.graph.operations.interfaces.computers.binary

import com.compute.graph.operations.objects.Gradient
import com.compute.graph.operations.objects.MathObject
import com.compute.graph.operations.objects.Scalar
import com.compute.graph.operations.objects.Tensor
import com.compute.graph.operations.objects.Shape
import kotlin.reflect.jvm.jvmName

/**
 * @Author: evgeny
 * @Date: 2019-07-22
 */
interface BinaryOperationShapeProcessor {
    fun computeShape(
        leftVal: MathObject,
        rightVal: MathObject
    ): Shape =
        when (leftVal) {
            is Gradient ->
                when (rightVal) {
                    is Tensor -> computeShape(leftVal, rightVal)
                    is Gradient -> computeShape(leftVal, rightVal)
                    is Scalar -> computeShape(leftVal, rightVal)
                    else -> throw IllegalArgumentException("Unexpected argument type ${rightVal::class.jvmName}")
                }
            is Tensor ->
                when (rightVal) {
                    is Tensor -> computeShape(leftVal, rightVal)
                    is Gradient -> computeShape(leftVal, rightVal)
                    is Scalar -> computeShape(leftVal, rightVal)
                    else -> throw IllegalArgumentException("Unexpected argument type ${rightVal::class.jvmName}")
                }
            is Scalar ->
                when (rightVal) {
                    is Tensor -> computeShape(leftVal, rightVal)
                    is Gradient -> computeShape(leftVal, rightVal)
                    is Scalar -> computeShape(leftVal, rightVal)
                    else -> throw IllegalArgumentException("Unexpected argument type ${rightVal::class.jvmName}")
                }

            else -> throw IllegalArgumentException("Unexpected argument type ${leftVal::class.jvmName}")
        }

    fun computeShape(
        leftArg: Tensor,
        rightArg: Tensor
    ): Shape

    fun computeShape(
        leftArg: Scalar,
        rightArg: Scalar
    ): Shape

    fun computeShape(
        leftArg: Tensor,
        rightArg: Scalar
    ): Shape

    fun computeShape(
        leftArg: Scalar,
        rightArg: Tensor
    ): Shape


    fun computeShape(
        leftArg: Tensor,
        rightArg: Gradient
    ): Shape

    fun computeShape(
        leftArg: Gradient,
        rightArg: Tensor
    ): Shape

    fun computeShape(
        leftArg: Scalar,
        rightArg: Gradient
    ): Shape

    fun computeShape(
        leftArg: Gradient,
        rightArg: Scalar
    ): Shape

    fun computeShape(
        leftArg: Gradient,
        rightArg: Gradient
    ): Shape
}