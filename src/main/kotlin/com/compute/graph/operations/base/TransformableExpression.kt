package com.compute.graph.operations.base

import com.compute.graph.operations.interfaces.Expression
import com.compute.graph.operations.interfaces.Transformable

abstract class TransformableExpression : Expression, Transformable {
    abstract override val children: List<TransformableExpression>
    override val parents: List<TransformableExpression>
        get() = mutableParents

    protected val mutableParents: MutableList<TransformableExpression> = mutableListOf()

    fun addParent(parent: TransformableExpression) {
        if (!mutableParents.contains(parent))
            mutableParents.add(parent)
    }

    fun removeParent(parent: TransformableExpression) {
        mutableParents.remove(parent)
    }
}