package com.compute.graph.operation.objects.operators

import com.compute.graph.operation.annotations.Operator
import com.compute.graph.operation.base.BinaryOperation
import com.compute.graph.operation.base.MathExpression
import com.compute.graph.operation.interfaces.ExpressionArgs

@Operator("/")
class DivOp(
        leftArgument: MathExpression,
        rightArgument: MathExpression
) : BinaryOperation(leftArgument, rightArgument) {

    override fun compute(args: ExpressionArgs): Double {
        return children[0].compute(args) / children[1].compute(args)
    }

    override fun differentiate() {
        TODO("Function \"${javaClass.name}.differentiate\" not implemented")
    }
}
