package com.compute.graph.operations.dsl.operations.unary.functions

import com.compute.graph.operations.base.util.UnaryOperationCorePattern
import com.compute.graph.operations.interfaces.core.PriorityCommonLevels
import com.compute.graph.operations.interfaces.core.unary.UNARY_ARGUMENT_PATTERN
import com.compute.graph.operations.objects.MathObject
import com.compute.graph.operations.objects.Scalar
import com.compute.graph.operations.objects.types.ScalarConstant
import kotlin.math.sin as sin_double

/**
 * @Author: evgeny
 * @Date: 2019-07-25
 */
object SinCore : UnaryOperationCorePattern() {
    override fun computeResult(arg: Scalar): MathObject =
        ScalarConstant(sin_double(arg.value))

    override fun computeDerivative(arg: MathObject): MathObject =
        cos(arg)

    override val isIdempotent: Boolean = false
    override val isInvolutional: Boolean = false
    override val toStringPattern: String = "sin($UNARY_ARGUMENT_PATTERN)"
    override val operationPriority: Int = PriorityCommonLevels.PREFIX
}

fun sin(arg: MathObject): MathObject =
    SinCore.computeResult(arg)
