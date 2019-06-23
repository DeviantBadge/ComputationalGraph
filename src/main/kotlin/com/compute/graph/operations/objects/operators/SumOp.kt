package com.compute.graph.operations.objects.operators

import com.compute.graph.operations.annotations.Operator
import com.compute.graph.operations.base.*
import com.compute.graph.operations.interfaces.ExpressionArgs
import com.compute.graph.operations.base.util.BinaryComputer

@Operator("+")
class SumOp(
    leftArgument: MathExpression,
    rightArgument: MathExpression
) : BinaryOperation(leftArgument, rightArgument) {

    override fun computeResult(
        leftVal: ComputationResult,
        rightVal: ComputationResult
    ): ComputationResult =
        SumComputer.compute(leftVal, rightVal)


    override fun differentiateForward(args: ExpressionArgs): MultipleResult {
        TODO("Function \"${javaClass.name}.differentiateForward\" not implemented")
    }

    override fun differentiateBackward(args: ExpressionArgs): MultipleResult {
        TODO("Function \"${javaClass.name}.differentiateBackward\" not implemented")
    }

    companion object SumComputer : BinaryComputer() {
        override fun compute(
            leftArg: ScalarComputationResult,
            rightArg: ScalarComputationResult
        ): ComputationResult =
            ScalarComputationResult(leftArg.value + rightArg.value)
    }
}

// todo for backward alg we put result in map and accumulate result in map
