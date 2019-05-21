package com.compute.graph.operation.base

/**
 * <p>Description:</P>
 * <p>Company:Alibaba</p>
 * @Author: evgeny.vorobyev
 * @Since: 1.0
 * @Version:1.0,Date:2019-05-21
 */

abstract class IndependentOperation: TransformableExpression()  {
    override val children: List<TransformableExpression>
        get() = listOf()
}