package com.compute.graph.operations.dsl.operations.unary.operators

import com.compute.graph.operations.base.util.UnaryOperationProcessorPattern
import com.compute.graph.operations.objects.MathObject
import com.compute.graph.operations.objects.Scalar
import com.compute.graph.operations.objects.types.ScalarConstant
import org.apache.commons.math3.special.Gamma

/**
 * @Author: evgeny
 * @Date: 2019-07-25
 */
// todo validation
object FactorialProcessor : UnaryOperationProcessorPattern() {

    override fun computeResult(arg: Scalar): MathObject =
        ScalarConstant(Gamma.gamma(arg.value))

    override fun derivative(arg: MathObject): MathObject =
        throw UnsupportedOperationException("Can not differentiate Gamma function (factorial)")
}

fun fact(arg: MathObject): MathObject =
    FactorialProcessor.computeResult(arg)

fun fact(arg: Number): Double =
    Gamma.gamma(arg.toDouble())