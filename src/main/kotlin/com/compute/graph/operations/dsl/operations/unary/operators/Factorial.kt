package com.compute.graph.operations.dsl.operations.unary.operators

import com.compute.graph.operations.base.util.UnaryOperationCorePattern
import com.compute.graph.operations.interfaces.core.PriorityCommonLevels
import com.compute.graph.operations.interfaces.core.unary.UNARY_ARGUMENT_PATTERN
import com.compute.graph.operations.objects.MathObject
import com.compute.graph.operations.objects.Scalar
import com.compute.graph.operations.objects.types.ScalarConstant
import org.apache.commons.math3.special.Gamma

/**
 * @Author: evgeny
 * @Date: 2019-07-25
 */
// todo validation
object FactorialCore : UnaryOperationCorePattern() {

    override fun computeResult(arg: Scalar): MathObject =
        ScalarConstant(Gamma.gamma(arg.value))

    override fun computeDerivative(arg: MathObject): MathObject =
        throw UnsupportedOperationException("Can not differentiate Gamma function (factorial)")

    override val isIdempotent: Boolean = false
    override val isInvolutional: Boolean = false
    override val toStringPattern: String = "$UNARY_ARGUMENT_PATTERN!"
    override val operationPriority: Int = PriorityCommonLevels.POSTFIX
}

fun fact(arg: MathObject): MathObject =
    FactorialCore.computeResult(arg)

fun fact(arg: Number): Double =
    Gamma.gamma(arg.toDouble())