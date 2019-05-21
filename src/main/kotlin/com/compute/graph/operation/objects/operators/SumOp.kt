package com.compute.graph.operation.objects.operators

import com.compute.graph.operation.base.BinaryOperation
import com.compute.graph.operation.base.TransformableExpression
import com.compute.graph.operation.interfaces.ExpressionArgs

class SumOp(
        leftArgument: TransformableExpression,
        rightArgument: TransformableExpression
) : BinaryOperation(leftArgument, rightArgument) {

    override fun compute(args: ExpressionArgs): Double {
        return children.fold(0.0) { sum, element -> sum + element.compute(args)}
    }

    override fun differentiate() {
        TODO("Function \"${javaClass.name}.differentiate\" not implemented")
    }
}
