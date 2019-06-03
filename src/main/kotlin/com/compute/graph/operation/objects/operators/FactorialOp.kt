package com.compute.graph.operation.objects.operators

import com.compute.graph.operation.annotations.Operator
import com.compute.graph.operation.base.*
import com.compute.graph.operation.interfaces.ExpressionArgs
import org.apache.commons.math3.special.Gamma

@Operator("!")
class FactorialOp(
    argument: MathExpression
) : UnaryOperation(argument) {

    // todo validation
    override fun compute(arg: ScalarComputationResult): ComputationResult =
        ScalarComputationResult(Gamma.gamma(arg.value + 1))

    override fun differentiateForward(args: ExpressionArgs): MultipleResult {
        TODO("Function \"${javaClass.name}.differentiateForward\" not implemented")
    }

    override fun differentiateBackward(args: ExpressionArgs): MultipleResult {
        TODO("Function \"${javaClass.name}.differentiateBackward\" not implemented")
    }
}
