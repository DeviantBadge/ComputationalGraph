package com.compute.graph.operation.objects

import com.compute.graph.operation.base.OperationType
import com.compute.graph.operation.base.TransformableExpression
import com.compute.graph.operation.interfaces.ExecutionResult
import com.compute.graph.operation.interfaces.ExpressionArgs

class Variable(val name: String) : TransformableExpression() {
    init {
        TODO("Need to check variables first")
    }

    override val mutableParents: MutableList<TransformableExpression> = mutableListOf()
    override val mutableChildren: MutableList<TransformableExpression> = mutableListOf()

    override fun compute(args: ExpressionArgs): ExecutionResult {

    }

    override fun differentiate() {
        TODO("Function \"${javaClass.name}.differentiate\" not implemented")
    }

    override fun toString(): String {
        return name
    }
}