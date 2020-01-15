package com.compute.graph.operations.interfaces.core.unary

import com.compute.graph.operations.objects.*

/**
 * @Author: evgeny
 * @Date: 2019-07-22
 */
interface UnaryOperationShapeProcessor {
    fun computeShape(
        arg: Shape
    ): Shape =
        when (arg) {
            is TensorShape -> computeShape(arg)
            is ScalarShape -> computeShape(arg)
            is GradientShape -> computeShape(arg)
            is MathExpressionShape -> computeShape(arg)
        }

    fun computeShape(arg: TensorShape): Shape

    fun computeShape(arg: ScalarShape): Shape

    fun computeShape(arg: GradientShape): Shape

    fun computeShape(arg: MathExpressionShape): Shape
}