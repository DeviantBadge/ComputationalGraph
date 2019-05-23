package com.compute.graph.operation.base

import com.compute.graph.operation.objects.TransformableDelegate
import kotlinx.coroutines.*

/**
 * <p>Description:</P>
 * <p>Company:Alibaba</p>
 * @Author: evgeny.vorobyev
 * @Since: 1.0
 * @Version:1.0,Date:2019-05-21
 */
abstract class TernarOperation(
        leftArgument: TransformableExpression,
        middleArgument: TransformableExpression,
        rightArgument: TransformableExpression
): TransformableExpression() {
    override val children: List<TransformableExpression>
        get() = listOf(leftArgument, middleArgument, rightArgument)


    var leftArgument: TransformableExpression
            by TransformableDelegate(this, leftArgument)
    var middleArgument: TransformableExpression
            by TransformableDelegate(this, middleArgument)
    var rightArgument: TransformableExpression
            by TransformableDelegate(this, rightArgument)
}
