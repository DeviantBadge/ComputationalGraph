package com.compute.graph.operations.interfaces.core.binary

import com.compute.graph.operations.objects.*

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
                    is MathExpressionShape -> computeShape(leftVal, rightVal)
                }
            is TensorShape ->
                when (rightVal) {
                    is TensorShape -> computeShape(leftVal, rightVal)
                    is GradientShape -> computeShape(leftVal, rightVal)
                    is ScalarShape -> computeShape(leftVal, rightVal)
                    is MathExpressionShape -> computeShape(leftVal, rightVal)
                }
            is ScalarShape ->
                when (rightVal) {
                    is TensorShape -> computeShape(leftVal, rightVal)
                    is GradientShape -> computeShape(leftVal, rightVal)
                    is ScalarShape -> computeShape(leftVal, rightVal)
                    is MathExpressionShape -> computeShape(leftVal, rightVal)
                }
            is MathExpressionShape ->
                when (rightVal) {
                    is TensorShape -> computeShape(leftVal, rightVal)
                    is GradientShape -> computeShape(leftVal, rightVal)
                    is ScalarShape -> computeShape(leftVal, rightVal)
                    is MathExpressionShape -> computeShape(leftVal, rightVal)
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
        leftArg: MathExpressionShape,
        rightArg: ScalarShape
    ): Shape

    fun computeShape(
        leftArg: MathExpressionShape,
        rightArg: TensorShape
    ): Shape

    fun computeShape(
        leftArg: MathExpressionShape,
        rightArg: GradientShape
    ): Shape

    fun computeShape(
        leftArg: ScalarShape,
        rightArg: MathExpressionShape
    ): Shape

    fun computeShape(
        leftArg: TensorShape,
        rightArg: MathExpressionShape
    ): Shape

    fun computeShape(
        leftArg: GradientShape,
        rightArg: MathExpressionShape
    ): Shape

    fun computeShape(
        leftArg: MathExpressionShape,
        rightArg: MathExpressionShape
    ): Shape
}