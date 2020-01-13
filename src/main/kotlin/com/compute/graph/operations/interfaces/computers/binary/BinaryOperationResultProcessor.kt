package com.compute.graph.operations.interfaces.computers.binary

import com.compute.graph.operations.objects.MathExpression
import com.compute.graph.operations.objects.Gradient
import com.compute.graph.operations.objects.MathObject
import com.compute.graph.operations.objects.Scalar
import com.compute.graph.operations.objects.Tensor
import kotlin.reflect.jvm.jvmName

/**
 * @Author: evgeny
 * @Date: 2019-07-22
 */
interface BinaryOperationResultProcessor {
    fun computeResult(
        leftVal: MathObject,
        rightVal: MathObject
    ): MathObject =
        if ((leftVal is MathExpression) or (rightVal is MathExpression)) {
            buildExpression(leftVal, rightVal)
        } else {
            when (leftVal) {
                is Gradient ->
                    when (rightVal) {
                        is Tensor -> computeResult(leftVal, rightVal)
                        is Gradient -> computeResult(leftVal, rightVal)
                        is Scalar -> computeResult(leftVal, rightVal)
                        else -> throw IllegalArgumentException("Unexpected argument type ${rightVal::class.jvmName}")
                    }
                is Tensor ->
                    when (rightVal) {
                        is Tensor -> computeResult(leftVal, rightVal)
                        is Gradient -> computeResult(leftVal, rightVal)
                        is Scalar -> computeResult(leftVal, rightVal)
                        else -> throw IllegalArgumentException("Unexpected argument type ${rightVal::class.jvmName}")
                    }
                is Scalar ->
                    when (rightVal) {
                        is Tensor -> computeResult(leftVal, rightVal)
                        is Gradient -> computeResult(leftVal, rightVal)
                        is Scalar -> computeResult(leftVal, rightVal)
                        else -> throw IllegalArgumentException("Unexpected argument type ${rightVal::class.jvmName}")
                    }

                else -> throw IllegalArgumentException("Unexpected argument type ${leftVal::class.jvmName}")
            }
        }

    fun buildExpression(
        leftVal: MathObject,
        rightVal: MathObject
    ): MathExpression

    fun computeResult(
        leftArg: Tensor,
        rightArg: Tensor
    ): MathObject

    fun computeResult(
        leftArg: Scalar,
        rightArg: Scalar
    ): MathObject

    fun computeResult(
        leftArg: Tensor,
        rightArg: Scalar
    ): MathObject

    fun computeResult(
        leftArg: Scalar,
        rightArg: Tensor
    ): MathObject


    fun computeResult(
        leftArg: Tensor,
        rightArg: Gradient
    ): Gradient

    fun computeResult(
        leftArg: Gradient,
        rightArg: Tensor
    ): Gradient

    fun computeResult(
        leftArg: Scalar,
        rightArg: Gradient
    ): Gradient

    fun computeResult(
        leftArg: Gradient,
        rightArg: Scalar
    ): Gradient

    fun computeResult(
        leftArg: Gradient,
        rightArg: Gradient
    ): Gradient
}