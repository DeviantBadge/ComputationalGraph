package com.compute.graph.operations.dsl.operations.unary.functions

import com.compute.graph.operations.base.util.UnaryOperationCorePattern
import com.compute.graph.operations.dsl.operations.binary.operators.div
import com.compute.graph.operations.interfaces.core.PriorityCommonLevels
import com.compute.graph.operations.interfaces.core.unary.UNARY_ARGUMENT_PATTERN
import com.compute.graph.operations.objects.MathObject
import com.compute.graph.operations.objects.Scalar
import com.compute.graph.operations.objects.types.ScalarConstant

object LnCore : UnaryOperationCorePattern() {
    override fun computeResult(arg: Scalar): MathObject =
        ScalarConstant(kotlin.math.cos(arg.value))

    override fun computeDerivative(arg: MathObject): MathObject =
        1 / arg

    override val isIdempotent: Boolean = false
    override val isInvolutional: Boolean = false
    override val toStringPattern: String = "ln($UNARY_ARGUMENT_PATTERN)"
    override val operationPriority: Int = PriorityCommonLevels.PREFIX
}

fun ln(arg: MathObject): MathObject =
    LnCore.computeResult(arg)

