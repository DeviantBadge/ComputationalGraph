package com.compute.graph.operations.interfaces.computers.binary

import com.compute.graph.operations.objects.*
import kotlin.reflect.jvm.jvmName

/**
 * @Author: evgeny
 * @Date: 2019-07-22
 */
interface BinaryOperationShapeProcessor {
    fun computeShape(
        leftVal: Shape,
        rightVal: Shape
    ): Shape =
        when (leftVal) {
            is GradientShape ->
                when (rightVal) {
                    is TensorShape -> computeShape(leftVal, rightVal)
                    is GradientShape -> computeShape(leftVal, rightVal)
                    is ScalarShape -> computeShape(leftVal, rightVal)
                    is UnknownExpressionShape -> computeShape(leftVal, rightVal)
                }
            is TensorShape ->
                when (rightVal) {
                    is TensorShape -> computeShape(leftVal, rightVal)
                    is GradientShape -> computeShape(leftVal, rightVal)
                    is ScalarShape -> computeShape(leftVal, rightVal)
                    is UnknownExpressionShape -> computeShape(leftVal, rightVal)
                }
            is ScalarShape ->
                when (rightVal) {
                    is TensorShape -> computeShape(leftVal, rightVal)
                    is GradientShape -> computeShape(leftVal, rightVal)
                    is ScalarShape -> computeShape(leftVal, rightVal)
                    is UnknownExpressionShape -> computeShape(leftVal, rightVal)
                }
            is UnknownExpressionShape ->
                when (rightVal) {
                    is TensorShape -> computeShape(leftVal, rightVal)
                    is GradientShape -> computeShape(leftVal, rightVal)
                    is ScalarShape -> computeShape(leftVal, rightVal)
                    is UnknownExpressionShape -> computeShape(leftVal, rightVal)
                }
        }

    fun computeShape(
        leftArg: TensorShape,
        rightArg: TensorShape
    ): Shape

    fun computeShape(
        leftArg: ScalarShape,
        rightArg: ScalarShape
    ): Shape

    fun computeShape(
        leftArg: TensorShape,
        rightArg: ScalarShape
    ): Shape

    fun computeShape(
        leftArg: ScalarShape,
        rightArg: TensorShape
    ): Shape


    fun computeShape(
        leftArg: TensorShape,
        rightArg: GradientShape
    ): Shape

    fun computeShape(
        leftArg: GradientShape,
        rightArg: TensorShape
    ): Shape

    fun computeShape(
        leftArg: ScalarShape,
        rightArg: GradientShape
    ): Shape

    fun computeShape(
        leftArg: GradientShape,
        rightArg: ScalarShape
    ): Shape

    fun computeShape(
        leftArg: GradientShape,
        rightArg: GradientShape
    ): Shape


    fun computeShape(
        leftArg: UnknownExpressionShape,
        rightArg: ScalarShape
    ): Shape

    fun computeShape(
        leftArg: UnknownExpressionShape,
        rightArg: TensorShape
    ): Shape

    fun computeShape(
        leftArg: UnknownExpressionShape,
        rightArg: GradientShape
    ): Shape

    fun computeShape(
        leftArg: ScalarShape,
        rightArg: UnknownExpressionShape
    ): Shape

    fun computeShape(
        leftArg: TensorShape,
        rightArg: UnknownExpressionShape
    ): Shape

    fun computeShape(
        leftArg: GradientShape,
        rightArg: UnknownExpressionShape
    ): Shape

    fun computeShape(
        leftArg: UnknownExpressionShape,
        rightArg: UnknownExpressionShape
    ): Shape
}