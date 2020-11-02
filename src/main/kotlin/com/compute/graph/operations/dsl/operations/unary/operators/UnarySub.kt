package com.compute.graph.operations.dsl.operations.unary.operators

import com.compute.graph.operations.base.util.UnaryOperationCorePattern
import com.compute.graph.operations.interfaces.core.PriorityCommonLevels
import com.compute.graph.operations.interfaces.core.unary.UNARY_ARGUMENT_PATTERN
import com.compute.graph.operations.objects.MathObject
import com.compute.graph.operations.objects.Scalar
import com.compute.graph.operations.objects.Shape
import com.compute.graph.operations.objects.types.ScalarConstant

object UnarySubCore : UnaryOperationCorePattern() {
    override fun computeResult(arg: Scalar): MathObject =
        ScalarConstant(-arg.value)

    override fun computeDerivative(arg: MathObject): MathObject =
        ScalarConstant(-1)

    override val isIdempotent: Boolean = false
    override val isInvolutional: Boolean = false
    override val toStringPattern: String = "-$UNARY_ARGUMENT_PATTERN"
    override val operationPriority: Int = PriorityCommonLevels.PREFIX
}

operator fun MathObject.unaryMinus(): MathObject =
    UnarySubCore.computeResult(this)

operator fun Shape.unaryMinus(): Shape =
    UnarySubCore.computeShape(this)
