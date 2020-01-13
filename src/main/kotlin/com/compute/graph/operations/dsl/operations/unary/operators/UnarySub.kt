package com.compute.graph.operations.dsl.operations.unary.operators

import com.compute.graph.operations.base.util.UnaryOperationProcessorPattern
import com.compute.graph.operations.objects.MathObject
import com.compute.graph.operations.objects.Scalar
import com.compute.graph.operations.objects.types.ScalarConstant

object UnarySubProcessor : UnaryOperationProcessorPattern() {
    override fun computeResult(arg: Scalar): MathObject =
        ScalarConstant(-arg.value)

    override fun derivative(arg: MathObject): MathObject =
        ScalarConstant(-1)
}

operator fun MathObject.unaryMinus(): MathObject =
    UnarySubProcessor.computeResult(this)
