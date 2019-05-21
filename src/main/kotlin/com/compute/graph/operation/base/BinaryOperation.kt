package com.compute.graph.operation.base

import com.compute.graph.operation.interfaces.ExpressionArgs
import com.compute.graph.operation.objects.TransformableDelegate

/**
 * <p>Description:</P>
 * <p>Company:Alibaba</p>
 * @Author: evgeny.vorobyev
 * @Since: 1.0
 * @Version:1.0,Date:2019-05-21
 */

abstract class BinaryOperation(
        leftArgument: TransformableExpression,
        rightArgument: TransformableExpression)
    : TransformableExpression() {

    override val children: List<TransformableExpression>
        get() = listOf(leftArgument, rightArgument)

    var leftArgument: TransformableExpression
            by TransformableDelegate(this, leftArgument)

    var rightArgument: TransformableExpression
            by TransformableDelegate(this, rightArgument)
}
