package com.compute.graph.operations.base.util

import com.compute.graph.operations.interfaces.computers.binary.BinaryOperationProcessor
import com.compute.graph.operations.objects.*
import com.compute.graph.util.extensions.mapGradientValues
import com.compute.graph.util.extensions.mapGradientValuesWith


abstract class BinaryOperationProcessorPattern
    : BinaryOperationProcessor {

    // *******************************************************************************************
    // Pre defined functions for result
    // *******************************************************************************************

    final override fun computeResult(
        leftVal: MathObject,
        rightVal: MathObject
    ): MathObject =
        super.computeResult(leftVal, rightVal)

    abstract override fun computeResult(leftArg: Tensor, rightArg: Tensor): MathObject

    abstract override fun computeResult(leftArg: Scalar, rightArg: Scalar): MathObject

    override fun buildExpression(leftVal: MathObject, rightVal: MathObject): MathExpression =
        BinaryOperation(leftVal, rightVal, this)


    override fun computeResult(leftArg: Tensor, rightArg: Scalar): MathObject =
        TODO("Implement Computation 'for_all in tensor'")

    override fun computeResult(leftArg: Scalar, rightArg: Tensor): MathObject =
        TODO("Implement Computation 'for_all in tensor'")

    override fun computeResult(leftArg: Tensor, rightArg: Gradient): Gradient =
        rightArg.mapGradientValues { computeResult(leftArg, it) }

    override fun computeResult(leftArg: Gradient, rightArg: Tensor): Gradient =
        leftArg.mapGradientValues { computeResult(it, rightArg) }

    override fun computeResult(leftArg: Scalar, rightArg: Gradient): Gradient =
        rightArg.mapGradientValues { computeResult(leftArg, it) }

    override fun computeResult(leftArg: Gradient, rightArg: Scalar): Gradient =
        leftArg.mapGradientValues { computeResult(it, rightArg) }

    override fun computeResult(leftArg: Gradient, rightArg: Gradient): Gradient =
        leftArg.mapGradientValuesWith(rightArg) { left, right -> computeResult(left, right) }


    // *******************************************************************************************
    // Pre defined functions for shape
    // *******************************************************************************************

    override fun computeShape(leftArg: ScalarShape, rightArg: ScalarShape): Shape =
        ScalarShape

    override fun computeShape(leftArg: ScalarShape, rightArg: TensorShape): Shape =
        rightArg

    override fun computeShape(leftArg: ScalarShape, rightArg: GradientShape): Shape =
        rightArg

    override fun computeShape(leftArg: ScalarShape, rightArg: UnknownExpressionShape): Shape =
        rightArg

    override fun computeShape(leftArg: TensorShape, rightArg: ScalarShape): Shape =
        leftArg

    override fun computeShape(leftArg: TensorShape, rightArg: TensorShape): Shape = TODO()

    override fun computeShape(leftArg: TensorShape, rightArg: GradientShape): Shape = TODO()

    override fun computeShape(leftArg: TensorShape, rightArg: UnknownExpressionShape): Shape = TODO()

    override fun computeShape(leftArg: GradientShape, rightArg: ScalarShape): Shape = TODO()

    override fun computeShape(leftArg: GradientShape, rightArg: TensorShape): Shape = TODO()

    override fun computeShape(leftArg: GradientShape, rightArg: GradientShape): Shape = TODO()

    override fun computeShape(leftArg: GradientShape, rightArg: UnknownExpressionShape): Shape = TODO()

    override fun computeShape(leftArg: UnknownExpressionShape, rightArg: ScalarShape): Shape = TODO()

    override fun computeShape(leftArg: UnknownExpressionShape, rightArg: TensorShape): Shape = TODO()

    override fun computeShape(leftArg: UnknownExpressionShape, rightArg: GradientShape): Shape = TODO()

    override fun computeShape(leftArg: UnknownExpressionShape, rightArg: UnknownExpressionShape): Shape = TODO()

    // *******************************************************************************************
    // Pre defined functions for derivatives
    // *******************************************************************************************

    abstract override fun computeLeftArgDerivative(leftArg: MathObject, rightArg: MathObject): MathObject

    abstract override fun computeRightArgDerivative(leftArg: MathObject, rightArg: MathObject): MathObject
}

