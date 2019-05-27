package com.compute.graph.operation.objects.operators

import com.compute.graph.operation.annotations.Operator
import com.compute.graph.operation.base.BinaryOperation
import com.compute.graph.operation.base.MathExpression
import com.compute.graph.operation.interfaces.ExpressionArgs
import kotlin.math.pow

@Operator("/")
class DivOp(
        leftArgument: MathExpression,
        rightArgument: MathExpression
) : BinaryOperation(leftArgument, rightArgument) {
    override fun compute(args: ExpressionArgs): Double {
        return leftArgument.compute(args) / rightArgument.compute(args)
    }

    override fun differentiate(varName: String, args: ExpressionArgs): Double =
            (leftArgument.differentiate(varName, args) * rightArgument.compute(args) -
                    rightArgument.differentiate(varName, args) * leftArgument.compute(args)) /
                    rightArgument.compute(args).pow(2)
}
