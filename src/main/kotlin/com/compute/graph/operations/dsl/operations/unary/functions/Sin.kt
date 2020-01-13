package com.compute.graph.operations.dsl.operations.unary.functions

import com.compute.graph.operations.base.util.UnaryOperationProcessorPattern
import com.compute.graph.operations.objects.MathObject
import com.compute.graph.operations.objects.Scalar
import com.compute.graph.operations.objects.types.ScalarConstant
import kotlin.math.sin as sin_double

/**
 * @Author: evgeny
 * @Date: 2019-07-25
 */
object SinProcessor : UnaryOperationProcessorPattern() {
    override fun computeResult(arg: Scalar): MathObject =
        ScalarConstant(sin_double(arg.value))

    override fun derivative(arg: MathObject): MathObject =
        cos(arg)
}

fun sin(arg: MathObject): MathObject =
    SinProcessor.computeResult(arg)
