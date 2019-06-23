package com.compute.graph.operations.objects.operators

import com.compute.graph.operations.annotations.Operator
import com.compute.graph.operations.base.*
import com.compute.graph.operations.base.util.UnaryComputer
import com.compute.graph.operations.interfaces.ExpressionArgs
import org.apache.commons.math3.special.Gamma

@Operator("!")
class FactorialOp(
    argument: MathExpression
) : UnaryOperation(argument) {

    override fun computeResult(arg: ComputationResult): ComputationResult =
        FactorialComputer.compute(arg)

    override fun differentiateForward(args: ExpressionArgs): MultipleResult {
        TODO("Function \"${javaClass.name}.differentiateForward\" not implemented")
    }

    override fun differentiateBackward(args: ExpressionArgs): MultipleResult {
        TODO("Function \"${javaClass.name}.differentiateBackward\" not implemented")
    }

    // todo validation
    companion object FactorialComputer : UnaryComputer() {
        override fun compute(arg: ScalarComputationResult): ComputationResult =
            ScalarComputationResult(Gamma.gamma(arg.value + 1))
    }
}
