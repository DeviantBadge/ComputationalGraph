package com.compute.graph.operation.base

import com.compute.graph.operation.interfaces.Expression
import com.compute.graph.operation.interfaces.Transformable

abstract class TransformableExpression: Expression, Transformable {
    final override val children: List<Expression>
        get() = mutableChildren
    final override val parents: List<Expression>
        get() = mutableParents

    protected abstract val mutableParents: MutableList<TransformableExpression>
    protected abstract val mutableChildren: MutableList<TransformableExpression>

    fun addChild(child: TransformableExpression) {
        mutableChildren.add(child)
        child.addParent(this)
    }

    fun addParent(parent: TransformableExpression) {
        if (mutableParents.contains(parent))
            mutableParents.add(parent)
    }
}