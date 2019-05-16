package com.compute.graph.operation.objects

import com.compute.graph.operation.base.Operator
import com.compute.graph.operation.base.TransformableExpression
import com.compute.graph.operation.interfaces.ExecutionResult
import com.compute.graph.operation.interfaces.ExpressionArgs

class SumOp: Operator() {
    override val mutableParents: MutableList<TransformableExpression>
        get() = mutableListOf()
    override val mutableChildren: MutableList<TransformableExpression> =
            mutableListOf()

    override fun compute(args: ExpressionArgs): ExecutionResult {
        TODO("Need implement execution result")
    }

}
