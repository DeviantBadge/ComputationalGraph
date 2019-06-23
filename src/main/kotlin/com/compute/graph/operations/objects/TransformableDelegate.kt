package com.compute.graph.operations.objects

import com.compute.graph.operations.base.TransformableExpression
import kotlin.reflect.KProperty

/**
 * <p>Description:</P>
 * <p>Company:Alibaba</p>
 * @Author: evgeny.vorobyev
 * @Since: 1.0
 * @Version:1.0,Date:2019-05-21
 */

class TransformableDelegate<T : TransformableExpression>(
    private val parent: T,
    private var delegated: T
) {
    init {
        delegated.addParent(parent)
    }

    operator fun getValue(
        thisRef: T,
        property: KProperty<*>
    ): T {
        return delegated
    }

    operator fun setValue(
        thisRef: T,
        property: KProperty<*>,
        value: T) {
        delegated.removeParent(thisRef)
        delegated = value
        value.addParent(thisRef)
    }
}