package com.compute.graph.operation.objects.operators

import com.compute.graph.operation.annotations.Operator
import com.compute.graph.operation.base.BinaryOperation
import com.compute.graph.operation.base.MathExpression
import com.compute.graph.operation.base.TransformableExpression
import com.compute.graph.operation.base.VectorOperation
import com.compute.graph.operation.interfaces.ExpressionArgs

@Operator("*")
class MulOp(
        arguments: MutableList<MathExpression>
) : VectorOperation(arguments) {
    constructor(vararg arguments: MathExpression): this(arguments.toMutableList())

    override fun compute(args: ExpressionArgs): Double {
        return children.fold(1.toDouble()) { mul, element -> mul * element.compute(args)}
    }

    override fun differentiate() {
        TODO("Function \"${javaClass.name}.differentiate\" not implemented")
    }
}
