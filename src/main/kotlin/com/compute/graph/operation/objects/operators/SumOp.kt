package com.compute.graph.operation.objects.operators

import com.compute.graph.operation.base.Operator
import com.compute.graph.operation.base.TransformableExpression
import com.compute.graph.operation.interfaces.ExpressionArgs

class SumOp : Operator() {

    override val mutableParents: MutableList<TransformableExpression> = mutableListOf()
    override val mutableChildren: MutableList<TransformableExpression> = mutableListOf()

    override fun compute(args: ExpressionArgs): Double {
        return children.fold(0.toDouble()) { sum, element -> sum + element.compute(args)}
    }

    override fun differentiate() {
        TODO("Function \"${javaClass.name}.differentiate\" not implemented")
    }
}
