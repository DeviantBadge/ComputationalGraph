package com.compute.graph.operation.base

import com.compute.graph.operation.objects.TransformableDelegate

sealed class MathExpression: TransformableExpression()

abstract class IndependentOperand: MathExpression()  {
    final override val children: List<MathExpression>
        get() = listOf()
}

abstract class IndependentOperation: MathExpression()  {
    final override val children: List<MathExpression>
        get() = listOf()
}

// todo how can we move parent/children logic into operation?
// problem - when we link $this into another object before construction - we can have an error
// todo try with spring context and without it, how much efficiency we will waste with spring context?
abstract class UnaryOperation(
        argument: MathExpression)
    : MathExpression() {

    override val children: List<MathExpression>
        get() = listOf(argument)

    val argument: MathExpression
            by TransformableDelegate(this, argument)
}

abstract class BinaryOperation(
        leftArgument: MathExpression,
        rightArgument: MathExpression)
    : MathExpression() {

    override val children: List<MathExpression>
        get() = listOf(leftArgument, rightArgument)

    var leftArgument: MathExpression
            by TransformableDelegate(this, leftArgument)

    var rightArgument: MathExpression
            by TransformableDelegate(this, rightArgument)
}

abstract class TernaryOperation(
        leftArgument: MathExpression,
        middleArgument: MathExpression,
        rightArgument: MathExpression
): MathExpression() {
    override val children: List<MathExpression>
        get() = listOf(leftArgument, middleArgument, rightArgument)


    var leftArgument: MathExpression
            by TransformableDelegate(this, leftArgument)
    var middleArgument: MathExpression
            by TransformableDelegate(this, middleArgument)
    var rightArgument: MathExpression
            by TransformableDelegate(this, rightArgument)
}

abstract class VectorOperation(
        private val arguments: MutableList<MathExpression>)
    : MathExpression() {

    override val children: List<MathExpression>
        get() = arguments

    constructor(vararg args: MathExpression): this(args.toMutableList())

    init {
        for(arg in arguments)
            arg.addParent(this)
    }

    fun addArg(arg: MathExpression) {
        arguments.add(arg)
        arg.addParent(this)
    }

    fun removeArg(arg: MathExpression) {
        arguments.add(arg)
        arg.addParent(this)
    }
}