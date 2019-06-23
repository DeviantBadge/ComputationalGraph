package com.compute.graph.operations.objects.functions

import com.compute.graph.operations.annotations.Function
import com.compute.graph.operations.base.*
import com.compute.graph.operations.interfaces.ExpressionArgs
import com.compute.graph.operations.base.util.UnaryComputer
import kotlin.math.sin

@Function("sin")
class SinFunction(
    argument: MathExpression
) : UnaryOperation(argument) {

    override fun computeResult(arg: ComputationResult): ComputationResult =
        SinComputer.compute(arg)

    override fun differentiateForward(args: ExpressionArgs): MultipleResult {
        TODO("Function \"${javaClass.name}.differentiateForward\" not implemented")
    }

    override fun differentiateBackward(args: ExpressionArgs): MultipleResult {
        TODO("Function \"${javaClass.name}.differentiateBackward\" not implemented")
    }

    companion object SinComputer : UnaryComputer() {
        override fun compute(arg: ScalarComputationResult): ComputationResult =
            ScalarComputationResult(sin(arg.value))
    }
}
