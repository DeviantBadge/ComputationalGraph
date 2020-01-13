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
object DivProcessor : BinaryOperationProcessorPattern() {
    override fun computeResult(leftArg: Tensor, rightArg: Tensor): MathObject =
        TODO("Function \"${javaClass.name}.computeResult\" not implemented")


    override fun computeResult(leftArg: Scalar, rightArg: Scalar): MathObject =
        ScalarConstant(leftArg.value / rightArg.value)

    override fun computeShape(leftArg: Tensor, rightArg: Tensor): Shape =
        TODO("Function \"${javaClass.name}.computeShape\" not implemented")

    override fun computeLeftArgDerivative(leftArg: MathObject, rightArg: MathObject): MathObject =
        1.0 / rightArg

    override fun computeRightArgDerivative(leftArg: MathObject, rightArg: MathObject): MathObject =
        leftArg / rightArg.pow(2.0)
}

operator fun MathObject.div(divisor: MathObject): MathObject =
    DivProcessor.computeResult(this, divisor)

operator fun Number.div(divisor: MathObject): MathObject =
    DivProcessor.compute(this, divisor)

operator fun MathObject.div(divisor: Number): MathObject =
    DivProcessor.compute(this, divisor)
