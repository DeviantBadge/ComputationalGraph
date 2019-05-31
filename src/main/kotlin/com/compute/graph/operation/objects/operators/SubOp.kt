package com.compute.graph.operation.objects.operators

import com.compute.graph.operation.annotations.Operator
import com.compute.graph.operation.base.*
import com.compute.graph.operation.interfaces.ExpressionArgs

@Operator("-")
class SubOp(
        leftArgument: MathExpression,
        rightArgument: MathExpression
) : BinaryOperation(leftArgument, rightArgument) {
    // todo create extension for execution result, that will handle operations
    // todo validation
    override fun compute(args: ExpressionArgs): ComputationResult =
            when (val leftChildResult = leftArgument.compute(args)) {
                is ScalarComputationResult ->
                    when (val rightChildResult = leftArgument.compute(args)) {
                        is ScalarComputationResult ->
                            ScalarComputationResult(leftChildResult.value - rightChildResult.value)
                        is VectorComputationResult -> TODO()
                        is MatrixComputationResult -> TODO()
                        is MultipleResult -> TODO()
                    }
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
