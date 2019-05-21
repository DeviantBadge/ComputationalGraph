package com.compute.graph.operation.objects.operators

import com.compute.graph.operation.base.BinaryOperation
import com.compute.graph.operation.base.TransformableExpression
import com.compute.graph.operation.interfaces.ExpressionArgs

class MulOp(
        leftArgument: TransformableExpression,
        rightArgument: TransformableExpression
) : BinaryOperation(leftArgument, rightArgument) {

    override fun compute(args: ExpressionArgs): Double {
        return children.fold(1.toDouble()) { mul, element -> mul * element.compute(args)}
    }

    override fun differentiate() {
        TODO("Function \"${javaClass.name}.differentiate\" not implemented")
    }
}
