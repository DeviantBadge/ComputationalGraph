package com.compute.graph.operation.objects.functions

import com.compute.graph.operation.annotations.Function
import com.compute.graph.operation.base.*
import com.compute.graph.operation.interfaces.ExpressionArgs
import kotlin.math.cos
import kotlin.math.sin

@Function("sin")
class SinFunction(
    argument: MathExpression
) : UnaryOperation(argument) {
    override fun compute(args: ExpressionArgs): ComputationResult =
        when (val childResult = argument.compute(args)) {
            is ScalarComputationResult -> ScalarComputationResult(sin(childResult.value))
            is VectorComputationResult -> TODO()
            is MatrixComputationResult -> TODO()
            is MultipleResult -> TODO()
        }

    override fun differentiateForward(args: ExpressionArgs): MultipleResult {
        TODO("Function \"${javaClass.name}.differentiateForward\" not implemented")
    }

    override fun differentiateBackward(args: ExpressionArgs): MultipleResult {
        TODO("Function \"${javaClass.name}.differentiateBackward\" not implemented")
    }

}
