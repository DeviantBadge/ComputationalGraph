package com.compute.graph.operation.objects.operators

import com.compute.graph.operation.annotations.Operator
import com.compute.graph.operation.base.*
import com.compute.graph.operation.interfaces.ExpressionArgs
import kotlin.math.cos
import kotlin.math.pow

@Operator("/")
class DivOp(
    leftArgument: MathExpression,
    rightArgument: MathExpression
) : BinaryOperation(leftArgument, rightArgument) {

    override fun compute(
        leftArg: ScalarComputationResult,
        rightArg: ScalarComputationResult
    ): ComputationResult =
        ScalarComputationResult(leftArg.value / rightArg.value)

    override fun differentiateForward(args: ExpressionArgs): MultipleResult {
        TODO("Function \"${javaClass.name}.differentiateForward\" not implemented")
    }

    override fun differentiateBackward(args: ExpressionArgs): MultipleResult {
        TODO("Function \"${javaClass.name}.differentiateBackward\" not implemented")
    }

}
