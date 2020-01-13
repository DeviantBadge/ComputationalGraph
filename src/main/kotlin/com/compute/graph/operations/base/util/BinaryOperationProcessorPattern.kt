package com.compute.graph.operations.base.util

import com.compute.graph.operations.base.BinaryOperation
import com.compute.graph.operations.objects.MathExpression
import com.compute.graph.operations.interfaces.computers.binary.BinaryOperationProcessor
import com.compute.graph.operations.objects.Gradient
import com.compute.graph.operations.objects.MathObject
import com.compute.graph.operations.objects.Scalar
import com.compute.graph.operations.objects.Tensor
import com.compute.graph.operations.objects.ScalarShape
import com.compute.graph.operations.objects.Shape
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

    final override fun computeShape(
        leftVal: MathObject,
        rightVal: MathObject
    ): Shape =
        super.computeShape(leftVal, rightVal)

    abstract override fun computeShape(leftArg: Tensor, rightArg: Tensor): Shape

    override fun computeShape(leftArg: Scalar, rightArg: Scalar): Shape =
        ScalarShape

    override fun computeShape(leftArg: Tensor, rightArg: Scalar): Shape =
        leftArg.shape

    override fun computeShape(leftArg: Scalar, rightArg: Tensor): Shape =
        rightArg.shape

    override fun computeShape(leftArg: Gradient, rightArg: Scalar): Shape =
        leftArg.shape

    override fun computeShape(leftArg: Scalar, rightArg: Gradient): Shape =
        rightArg.shape

    override fun computeShape(leftArg: Gradient, rightArg: Tensor): Shape =
        TODO("Implement gradient shape")

    override fun computeShape(leftArg: Tensor, rightArg: Gradient): Shape =
        TODO("Implement gradient shape")

    override fun computeShape(leftArg: Gradient, rightArg: Gradient): Shape =
        TODO("Implement gradient shape")


    // *******************************************************************************************
    // Pre defined functions for derivatives
    // *******************************************************************************************

    abstract override fun computeLeftArgDerivative(leftArg: MathObject, rightArg: MathObject): MathObject

    abstract override fun computeRightArgDerivative(leftArg: MathObject, rightArg: MathObject): MathObject
}

