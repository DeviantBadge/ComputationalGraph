package com.compute.graph.operations.dsl.operations.binary.operators

import com.compute.graph.operations.base.util.BinaryOperationCorePattern
import com.compute.graph.operations.dsl.operations.unary.functions.ln
import com.compute.graph.operations.interfaces.core.PriorityCommonLevels
import com.compute.graph.operations.interfaces.core.binary.LEFT_ARGUMENT_PATTERN
import com.compute.graph.operations.interfaces.core.binary.RIGHT_ARGUMENT_PATTERN
import com.compute.graph.operations.objects.MathObject
import com.compute.graph.operations.objects.Scalar
import com.compute.graph.operations.objects.Tensor
import com.compute.graph.operations.objects.types.ScalarConstant
import com.compute.graph.util.extensions.compute
import kotlin.math.pow


object PowCore : BinaryOperationCorePattern() {

    override fun computeResult(leftArg: Tensor, rightArg: Tensor): MathObject {
        TODO("Function \"${javaClass.name}.computeResult\" not implemented")
    }

    override fun computeResult(leftArg: Scalar, rightArg: Scalar): MathObject =
        ScalarConstant(leftArg.value.pow(rightArg.value))

    override fun computeLeftArgDerivative(leftArg: MathObject, rightArg: MathObject): MathObject =
        rightArg * leftArg.pow(rightArg - 1.0)

    override fun computeRightArgDerivative(leftArg: MathObject, rightArg: MathObject): MathObject =
        ln(leftArg) * leftArg.pow(rightArg)

    override val isCommutative: Boolean = false
    override val isAntiCommutative: Boolean = false
    override val isAssociative: Boolean = false
    override val toStringPattern: String = "$LEFT_ARGUMENT_PATTERN^$RIGHT_ARGUMENT_PATTERN"
    override val operationPriority: Int = PriorityCommonLevels.POWER
}

infix fun MathObject.pow(divisor: MathObject): MathObject =
    PowCore.computeResult(this, divisor)

infix fun Number.pow(divisor: MathObject): MathObject =
    PowCore.compute(this, divisor)

infix fun MathObject.pow(divisor: Number): MathObject =
    PowCore.compute(this, divisor)
