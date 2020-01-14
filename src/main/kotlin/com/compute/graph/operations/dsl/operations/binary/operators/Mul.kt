package com.compute.graph.operations.dsl.operations.binary.operators

import com.compute.graph.operations.base.util.BinaryOperationProcessorPattern
import com.compute.graph.operations.objects.MathObject
import com.compute.graph.operations.objects.Scalar
import com.compute.graph.operations.objects.Tensor
import com.compute.graph.operations.objects.Shape
import com.compute.graph.operations.objects.types.ScalarConstant
import com.compute.graph.util.extensions.compute

/**
 * @Author: evgeny
 * @Date: 2019-07-25
 */

object MulProcessor : BinaryOperationProcessorPattern() {
    override fun computeResult(leftArg: Tensor, rightArg: Tensor): MathObject =
        TODO("Function \"${javaClass.name}.computeResult\" not implemented")


    override fun computeResult(leftArg: Scalar, rightArg: Scalar): MathObject =
        ScalarConstant(leftArg.value * rightArg.value)

    override fun computeLeftArgDerivative(leftArg: MathObject, rightArg: MathObject): MathObject =
        rightArg

    override fun computeRightArgDerivative(leftArg: MathObject, rightArg: MathObject): MathObject =
        leftArg
}

operator fun MathObject.times(divisor: MathObject): MathObject =
    MulProcessor.computeResult(this, divisor)

operator fun Number.times(divisor: MathObject): MathObject =
    MulProcessor.compute(this, divisor)

operator fun MathObject.times(divisor: Number): MathObject =
    MulProcessor.compute(this, divisor)
