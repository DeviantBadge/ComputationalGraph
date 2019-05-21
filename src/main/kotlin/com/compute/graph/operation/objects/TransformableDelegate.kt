package com.compute.graph.operation.objects

import com.compute.graph.operation.base.TransformableExpression
import kotlin.reflect.KProperty

/**
 * <p>Description:</P>
 * <p>Company:Alibaba</p>
 * @Author: evgeny.vorobyev
 * @Since: 1.0
 * @Version:1.0,Date:2019-05-21
 */

final class TransformableDelegate (
        private val parent: TransformableExpression,
        private var delegated: TransformableExpression
){
    init {
        delegated.addParent(parent)
    }

    operator fun getValue(
            thisRef: TransformableExpression,
            property: KProperty<*>
    ): TransformableExpression {
        return delegated
    }

    operator fun setValue(
            thisRef: TransformableExpression,
            property: KProperty<*>,
            value: TransformableExpression) {
        delegated.removeParent(thisRef)
        delegated = value
        value.addParent(thisRef)
    }
}