package com.compute.graph.operation.objects.operators

import com.compute.graph.operation.base.BinaryOperation
import com.compute.graph.operation.base.TransformableExpression
import com.compute.graph.operation.interfaces.ExpressionArgs

class SubOp(
        leftArgument: TransformableExpression,
        rightArgument: TransformableExpression
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
