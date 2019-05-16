package com.compute.graph.operation.objects

import com.compute.graph.operation.base.OperationType
import com.compute.graph.operation.base.Operator
import com.compute.graph.operation.base.TransformableExpression
import com.compute.graph.operation.interfaces.ExecutionResult
import com.compute.graph.operation.interfaces.ExpressionArgs
import com.compute.graph.operation.interfaces.PropertyHolder

class SubOp : Operator() {

    override val mutableParents: MutableList<TransformableExpression> = mutableListOf()
    override val mutableChildren: MutableList<TransformableExpression> = mutableListOf()

    // todo create extension for execution result, that will handle operations
    // todo validation
    override fun compute(args: ExpressionArgs): ExecutionResult {
        return SimpleResult(mutableChildren[0].compute(args).result - mutableChildren[1].compute(args).result)
    }

    override fun differentiate() {
        TODO("Function \"${javaClass.name}.differentiate\" not implemented")
    }
}
