package com.compute.graph.operation.objects.operators

import com.compute.graph.operation.annotations.Operator
import com.compute.graph.operation.base.BinaryOperation
import com.compute.graph.operation.base.MathExpression
import com.compute.graph.operation.base.UnaryOperation
import com.compute.graph.operation.interfaces.ExpressionArgs

@Operator("+")
class UnarySumOp(
        argument: MathExpression
) : UnaryOperation(argument) {

    // todo create extension for execution result, that will handle operations
    // todo validation
    override fun compute(args: ExpressionArgs): Double {
        return argument.compute(args)
    }

    override fun differentiate(varName: String, args: ExpressionArgs): Double =
            argument.differentiate(varName, args)
}
