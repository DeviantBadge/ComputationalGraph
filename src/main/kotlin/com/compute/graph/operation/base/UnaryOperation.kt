package com.compute.graph.operation.base

import com.compute.graph.operation.objects.TransformableDelegate

/**
 * <p>Description:</P>
 * <p>Company:Alibaba</p>
 * @Author: evgeny.vorobyev
 * @Since: 1.0
 * @Version:1.0,Date:2019-05-21
 */
// todo how can we move parent/children logic into operation?
// problem - when we link $this into another object before construction - we can have an error
// todo try with spring context and without it, how much efficiency we will waste with spring context?
abstract class UnaryOperation(
        argument: TransformableExpression)
    : TransformableExpression() {

    override val children: List<TransformableExpression>
        get() = listOf(argument)

    val argument: TransformableExpression
            by TransformableDelegate(this, argument)
}

