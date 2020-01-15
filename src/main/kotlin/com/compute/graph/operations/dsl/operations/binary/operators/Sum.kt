package com.compute.graph.operations.dsl.operations.binary.operators

import com.compute.graph.operations.base.util.BinaryOperationCorePattern
import com.compute.graph.operations.interfaces.core.PriorityCommonLevels
import com.compute.graph.operations.interfaces.core.binary.LEFT_ARGUMENT_PATTERN
import com.compute.graph.operations.interfaces.core.binary.RIGHT_ARGUMENT_PATTERN
import com.compute.graph.operations.objects.MathObject
import com.compute.graph.operations.objects.Scalar
import com.compute.graph.operations.objects.Tensor
import com.compute.graph.operations.objects.types.ScalarConstant
import com.compute.graph.util.extensions.compute


object SumCore : BinaryOperationCorePattern() {

    override fun computeResult(leftArg: Tensor, rightArg: Tensor): MathObject {
        TODO("Function \"${javaClass.name}.computeResult\" not implemented")
    }

    override fun computeResult(leftArg: Scalar, rightArg: Scalar): MathObject =
        ScalarConstant(leftArg.value + rightArg.value)

    override fun computeLeftArgDerivative(leftArg: MathObject, rightArg: MathObject): MathObject =
        ScalarConstant(1.0)

    override fun computeRightArgDerivative(leftArg: MathObject, rightArg: MathObject): MathObject =
        ScalarConstant(1.0)

    override val isCommutative: Boolean = true
    override val isAntiCommutative: Boolean = false
    override val isAssociative: Boolean = true
    override val toStringPattern: String = "$LEFT_ARGUMENT_PATTERN+$RIGHT_ARGUMENT_PATTERN"
    override val operationPriority: Int = PriorityCommonLevels.ADDITIVE
}

operator fun MathObject.plus(divisor: MathObject): MathObject =
    SumCore.computeResult(this, divisor)

operator fun Number.plus(divisor: MathObject): MathObject =
    SumCore.compute(this, divisor)

operator fun MathObject.plus(divisor: Number): MathObject =
    SumCore.compute(this, divisor)