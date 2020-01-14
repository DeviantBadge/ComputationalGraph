package com.compute.graph.operations.objects

/**
 * @Author: evgeny
 * @Date: 09/01/2020
 */
sealed class Shape

sealed class AlgebraicShape: Shape()

object ScalarShape: AlgebraicShape()

class UnknownExpressionShape: Shape()

class TensorShape(
    val shape: List<Int>
): AlgebraicShape() {
    override fun equals(other: Any?): Boolean {
        if (other is TensorShape) {
            return other.shape == this.shape
        }
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return shape.hashCode()
    }
}

class GradientShape(
    val shape: Map<MathExpression, Shape>
): Shape() {
    override fun equals(other: Any?): Boolean {
        if (other is GradientShape) {
            return other.shape == this.shape
        }
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return shape.hashCode()
    }
}