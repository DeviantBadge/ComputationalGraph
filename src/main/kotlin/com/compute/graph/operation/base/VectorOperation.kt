package com.compute.graph.operation.base

/**
 * <p>Description:</P>
 * <p>Company:Alibaba</p>
 * @Author: evgeny.vorobyev
 * @Since: 1.0
 * @Version:1.0,Date:2019-05-21
 */

abstract class VectorOperation(
        private val arguments: MutableList<TransformableExpression>)
    : TransformableExpression() {

    override val children: List<TransformableExpression>
        get() = arguments

    constructor(vararg args: TransformableExpression): this(args.toMutableList())

    init {
        for(arg in arguments)
            arg.addParent(this)
    }

    fun addArg(arg: TransformableExpression) {
        arguments.add(arg)
        arg.addParent(this)
    }

    fun removeArg(arg: TransformableExpression) {
        arguments.add(arg)
        arg.addParent(this)
    }
}