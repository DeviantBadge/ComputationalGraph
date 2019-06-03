package com.compute.graph.operation.objects.operators

import com.compute.graph.operation.annotations.Operator
import com.compute.graph.operation.base.*
import com.compute.graph.operation.interfaces.ExpressionArgs

@Operator("-")
class UnarySubOp(
    argument: MathExpression
) : UnaryOperation(argument) {

    override fun compute(arg: ScalarComputationResult): ComputationResult =
        ScalarComputationResult(-arg.value)

    override fun differentiateForward(args: ExpressionArgs): MultipleResult {
        TODO("Function \"${javaClass.name}.differentiateForward\" not implemented")
    }

    override fun differentiateBackward(args: ExpressionArgs): MultipleResult {
        TODO("Function \"${javaClass.name}.differentiateBackward\" not implemented")
    }

}
