package com.compute.graph.operations.dsl.operations.unary.functions

import com.compute.graph.operations.base.util.UnaryOperationProcessorPattern
import com.compute.graph.operations.dsl.operations.unary.operators.unaryMinus
import com.compute.graph.operations.objects.MathObject
import com.compute.graph.operations.objects.Scalar
import com.compute.graph.operations.objects.types.ScalarConstant
import kotlin.math.cos as cos_double

object CosProcessor : UnaryOperationProcessorPattern() {

    override fun computeResult(arg: Scalar): MathObject =
        ScalarConstant(cos_double(arg.value))

    override fun derivative(arg: MathObject): MathObject =
        -sin(arg)
}

fun cos(arg: MathObject): MathObject =
    CosProcessor.computeResult(arg)
