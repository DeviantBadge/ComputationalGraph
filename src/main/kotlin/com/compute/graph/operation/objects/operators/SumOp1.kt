package com.compute.graph.operation.objects.operators

import com.compute.graph.operation.annotations.Constant
import com.compute.graph.operation.base.BinaryOperation
import com.compute.graph.operation.base.TransformableExpression
import com.compute.graph.operation.interfaces.ExpressionArgs
import org.springframework.stereotype.Component

@Component
@Constant
class SumOp1(
        leftArgument: TransformableExpression,
        rightArgument: TransformableExpression
) : BinaryOperation(leftArgument, rightArgument) {
    constructor(vararg children: TransformableExpression): this(children[0], children[1])

    override fun compute(args: ExpressionArgs): Double {
        return children.fold(0.0) { sum, element -> sum + element.compute(args)}
    }

    override fun differentiate() {
        TODO("Function \"${javaClass.name}.differentiate\" not implemented")
    }
}
