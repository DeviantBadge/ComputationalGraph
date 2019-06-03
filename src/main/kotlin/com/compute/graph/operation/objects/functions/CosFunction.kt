package com.compute.graph.operation.objects.functions

import com.compute.graph.operation.annotations.Function
import com.compute.graph.operation.base.*
import com.compute.graph.operation.interfaces.ExpressionArgs
import kotlin.math.cos

@Function("cos")
class CosFunction(
    argument: MathExpression
) : UnaryOperation(argument) {

    override fun compute(arg: ScalarComputationResult): ComputationResult =
        ScalarComputationResult(cos(arg.value))


    override fun differentiateForward(args: ExpressionArgs): MultipleResult {
        TODO("Function \"${javaClass.name}.differentiateForward\" not implemented")
    }

    override fun differentiateBackward(args: ExpressionArgs): MultipleResult {
        TODO("Function \"${javaClass.name}.differentiateBackward\" not implemented")
    }
}