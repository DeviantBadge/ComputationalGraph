package com.compute.graph.operations.objects.operators

import com.compute.graph.operations.annotations.Operator
import com.compute.graph.operations.base.*
import com.compute.graph.operations.interfaces.ExpressionArgs
import com.compute.graph.operations.base.util.UnaryComputer
import org.apache.commons.math3.special.Gamma

@Operator("+")
class UnarySumOp(
    argument: MathExpression
) : UnaryOperation(argument) {

    override fun computeResult(arg: ComputationResult): ComputationResult =
        UnarySumComputer.compute(arg)

    override fun differentiateForward(args: ExpressionArgs): MultipleResult {
        TODO("Function \"${javaClass.name}.differentiateForward\" not implemented")
    }

    override fun differentiateBackward(args: ExpressionArgs): MultipleResult {
        TODO("Function \"${javaClass.name}.differentiateBackward\" not implemented")
    }

    companion object UnarySumComputer : UnaryComputer() {
        override fun compute(arg: ScalarComputationResult): ComputationResult =
            ScalarComputationResult(Gamma.gamma(arg.value + 1))
    }
}
