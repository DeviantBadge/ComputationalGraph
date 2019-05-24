package com.compute.graph.operation.objects.operators

import com.compute.graph.operation.annotations.Operator
import com.compute.graph.operation.base.BinaryOperation
import com.compute.graph.operation.base.MathExpression
import com.compute.graph.operation.interfaces.ExpressionArgs

@Operator("-")
class SubOp(
        leftArgument: MathExpression,
        rightArgument: MathExpression
) : BinaryOperation(leftArgument, rightArgument) {

    // todo create extension for execution result, that will handle operations
    // todo validation
    override fun compute(args: ExpressionArgs): Double {
        return leftArgument.compute(args) - rightArgument.compute(args)
    }

    override fun differentiate() {
        TODO("Function \"${javaClass.name}.differentiate\" not implemented")
    }
}
