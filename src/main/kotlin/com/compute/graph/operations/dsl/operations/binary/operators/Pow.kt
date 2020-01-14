package com.compute.graph.operations.dsl.operations.binary.operators

import com.compute.graph.operations.base.util.BinaryOperationProcessorPattern
import com.compute.graph.operations.dsl.operations.unary.functions.ln
import com.compute.graph.operations.objects.MathObject
import com.compute.graph.operations.objects.Scalar
import com.compute.graph.operations.objects.Tensor
import com.compute.graph.operations.objects.Shape
import com.compute.graph.operations.objects.types.ScalarConstant
import com.compute.graph.util.extensions.compute
import kotlin.math.pow


object PowProcessor : BinaryOperationProcessorPattern() {

    override fun computeResult(leftArg: Tensor, rightArg: Tensor): MathObject {
        TODO("Function \"${javaClass.name}.computeResult\" not implemented")
    }

    override fun computeResult(leftArg: Scalar, rightArg: Scalar): MathObject =
        ScalarConstant(leftArg.value.pow(rightArg.value))

    override fun computeLeftArgDerivative(leftArg: MathObject, rightArg: MathObject): MathObject =
        rightArg * leftArg.pow(rightArg - 1.0)

    override fun computeRightArgDerivative(leftArg: MathObject, rightArg: MathObject): MathObject =
        ln(leftArg) * leftArg.pow(rightArg)

}

infix fun MathObject.pow(divisor: MathObject): MathObject =
    PowProcessor.computeResult(this, divisor)

infix fun Number.pow(divisor: MathObject): MathObject =
    PowProcessor.compute(this, divisor)

infix fun MathObject.pow(divisor: Number): MathObject =
    PowProcessor.compute(this, divisor)
