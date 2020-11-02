package com.compute.graph.operations.dsl.operations.binary.operators

import com.compute.graph.operations.base.util.BinaryOperationCorePattern
import com.compute.graph.operations.interfaces.core.PriorityCommonLevels
import com.compute.graph.operations.interfaces.core.binary.AssociativityType
import com.compute.graph.operations.interfaces.core.binary.LEFT_ARGUMENT_PATTERN
import com.compute.graph.operations.interfaces.core.binary.RIGHT_ARGUMENT_PATTERN
import com.compute.graph.operations.objects.MathObject
import com.compute.graph.operations.objects.Scalar
import com.compute.graph.operations.objects.Shape
import com.compute.graph.operations.objects.Tensor
import com.compute.graph.operations.objects.types.ScalarConstant
import com.compute.graph.util.extensions.compute

/**
 * @Author: evgeny
 * @Date: 2019-07-25
 */

object MulCore : BinaryOperationCorePattern() {
    override fun computeResult(leftArg: Tensor, rightArg: Tensor): MathObject =
        TODO("Function \"${javaClass.name}.computeResult\" not implemented")


    override fun computeResult(leftArg: Scalar, rightArg: Scalar): MathObject =
        ScalarConstant(leftArg.value * rightArg.value)

    override fun computeLeftArgDerivative(leftArg: MathObject, rightArg: MathObject): MathObject =
        rightArg

    override fun computeRightArgDerivative(leftArg: MathObject, rightArg: MathObject): MathObject =
        leftArg

    // todo - with some shape conditions this operation is commutative
    override val isCommutative: Boolean = false
    override val isAntiCommutative: Boolean = false
    override val associativityType: AssociativityType = AssociativityType.LEFT
    override val toStringPattern: String = "$LEFT_ARGUMENT_PATTERN*$RIGHT_ARGUMENT_PATTERN"
    override val operationPriority: Int = PriorityCommonLevels.MULTIPLICATIVE
}

operator fun MathObject.times(divisor: MathObject): MathObject =
    MulCore.computeResult(this, divisor)

operator fun Number.times(divisor: MathObject): MathObject =
    MulCore.compute(this, divisor)

operator fun MathObject.times(divisor: Number): MathObject =
    MulCore.compute(this, divisor)


operator fun Shape.times(divisor: Shape): Shape =
    MulCore.computeShape(this, divisor)
