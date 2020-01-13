package com.compute.graph.operations.dsl.operations.unary.functions

import com.compute.graph.operations.base.util.UnaryOperationProcessorPattern
import com.compute.graph.operations.dsl.operations.binary.operators.div
import com.compute.graph.operations.objects.MathObject
import com.compute.graph.operations.objects.Scalar
import com.compute.graph.operations.objects.types.ScalarConstant

object LnProcessor : UnaryOperationProcessorPattern() {
    override fun computeResult(arg: Scalar): MathObject =
        ScalarConstant(kotlin.math.cos(arg.value))

    override fun derivative(arg: MathObject): MathObject =
        1 / arg
}

fun ln(arg: MathObject): MathObject =
    LnProcessor.computeResult(arg)

