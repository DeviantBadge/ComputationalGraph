package com.compute.graph.operations.dsl.operations.unary.functions

import com.compute.graph.operations.base.util.UnaryOperationCorePattern
import com.compute.graph.operations.dsl.operations.unary.operators.unaryMinus
import com.compute.graph.operations.interfaces.core.PriorityCommonLevels
import com.compute.graph.operations.interfaces.core.unary.UNARY_ARGUMENT_PATTERN
import com.compute.graph.operations.objects.MathObject
import com.compute.graph.operations.objects.Scalar
import com.compute.graph.operations.objects.Shape
import com.compute.graph.operations.objects.types.ScalarConstant
import kotlin.math.cos as cos_double

object CosCore : UnaryOperationCorePattern() {

    override fun computeResult(arg: Scalar): MathObject =
        ScalarConstant(cos_double(arg.value))

    override fun computeDerivative(arg: MathObject): MathObject =
        -sin(arg)

    override val isIdempotent: Boolean = false
    override val isInvolutional: Boolean = false
    override val toStringPattern: String = "cos($UNARY_ARGUMENT_PATTERN)"
    override val operationPriority: Int = PriorityCommonLevels.PREFIX
}

fun cos(arg: MathObject): MathObject =
    CosCore.computeResult(arg)

fun cos(arg: Shape): Shape =
    CosCore.computeShape(arg)
