package com.compute.graph.operations.dsl.operations.binary.operators

import com.compute.graph.operations.base.util.BinaryOperationProcessorPattern
import com.compute.graph.operations.objects.MathObject
import com.compute.graph.operations.objects.Scalar
import com.compute.graph.operations.objects.Tensor
import com.compute.graph.operations.objects.Shape
import com.compute.graph.operations.objects.types.ScalarConstant
import com.compute.graph.util.extensions.compute


object SumProcessor : BinaryOperationProcessorPattern() {

    override fun computeResult(leftArg: Tensor, rightArg: Tensor): MathObject {
        TODO("Function \"${javaClass.name}.computeResult\" not implemented")
    }

    override fun computeResult(leftArg: Scalar, rightArg: Scalar): MathObject =
        ScalarConstant(leftArg.value + rightArg.value)


    override fun computeShape(leftArg: Tensor, rightArg: Tensor): Shape {
        TODO("Function \"${javaClass.name}.computeShape\" not implemented")
    }

    override fun computeLeftArgDerivative(leftArg: MathObject, rightArg: MathObject): MathObject =
        ScalarConstant(1.0)

    override fun computeRightArgDerivative(leftArg: MathObject, rightArg: MathObject): MathObject =
        ScalarConstant(1.0)
}

operator fun MathObject.plus(divisor: MathObject): MathObject =
    SumProcessor.computeResult(this, divisor)

operator fun Number.plus(divisor: MathObject): MathObject =
    SumProcessor.compute(this, divisor)

operator fun MathObject.plus(divisor: Number): MathObject =
    SumProcessor.compute(this, divisor)