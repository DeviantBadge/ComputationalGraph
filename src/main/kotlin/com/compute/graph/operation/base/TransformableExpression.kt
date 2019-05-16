package com.compute.graph.operation.base

import com.compute.graph.operation.interfaces.Expression
import com.compute.graph.operation.interfaces.Transformable

abstract class TransformableExpression: Expression, Transformable {
    override val children: List<Expression>
        get() = mutableChildren
    override val parents: List<Expression>
        get() = mutableParents

    protected abstract val mutableParents: MutableList<TransformableExpression>
    protected abstract val mutableChildren: MutableList<TransformableExpression>
}