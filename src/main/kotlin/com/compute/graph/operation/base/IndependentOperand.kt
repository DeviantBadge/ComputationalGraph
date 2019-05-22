package com.compute.graph.operation.base

/**
 * @Author: evgeny.vorobyev
 * @Since: 1.0
 * @Version:1.0,Date:2019-05-22
 */
abstract class IndependentOperand: TransformableExpression()  {
    final override val children: List<TransformableExpression>
        get() = listOf()
}