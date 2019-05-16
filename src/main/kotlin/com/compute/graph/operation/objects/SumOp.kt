package com.compute.graph.operation.objects

import com.compute.graph.operation.base.OperationType
import com.compute.graph.operation.base.Operator
import com.compute.graph.operation.base.TransformableExpression
import com.compute.graph.operation.interfaces.ExecutionResult
import com.compute.graph.operation.interfaces.ExpressionArgs
import com.compute.graph.operation.interfaces.PropertyHolder

class SumOp : Operator() {

    override val mutableParents: MutableList<TransformableExpression> = mutableListOf()
    override val mutableChildren: MutableList<TransformableExpression> = mutableListOf()

    override fun compute(args: ExpressionArgs): ExecutionResult {
        TODO("Need implement execution result")
    }

    override fun differentiate() {
        TODO("Function \"${javaClass.name}.differentiate\" not implemented")
    }
}
