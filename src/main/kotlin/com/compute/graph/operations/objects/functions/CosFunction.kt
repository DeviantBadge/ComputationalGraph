package com.compute.graph.operations.objects.functions

import com.compute.graph.operations.annotations.Function
import com.compute.graph.operations.base.*
import com.compute.graph.operations.base.util.UnaryComputer
import com.compute.graph.operations.interfaces.ExpressionArgs
import kotlin.math.cos

@Function("cos")
class CosFunction(
    argument: MathExpression
) : UnaryOperation(argument) {

    override fun computeResult(arg: ComputationResult): ComputationResult =
        CosComputer.compute(arg)

    override fun differentiateForward(args: ExpressionArgs): MultipleResult {
        TODO("Function \"${javaClass.name}.differentiateForward\" not implemented")
    }

    override fun differentiateBackward(args: ExpressionArgs): MultipleResult {
        TODO("Function \"${javaClass.name}.differentiateBackward\" not implemented")
    }

    companion object CosComputer : UnaryComputer() {
        override fun compute(arg: ScalarComputationResult): ComputationResult =
            ScalarComputationResult(cos(arg.value))
    }
}
