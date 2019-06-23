package com.compute.graph.operations.base

import com.compute.graph.operations.interfaces.ExpressionContext
import com.compute.graph.operations.objects.TransformableDelegate

// todo create functions
// todo create systems
// todo implement simple operators for it in builder, to avoid some integration problems
sealed class MathExpression
    : TransformableExpression() {

    final override fun compute(
        context: ExpressionContext
    ): ComputationResult =
        context[this] ?: computeResult(context).also { context[this] = it }

    protected abstract fun computeResult(
        context: ExpressionContext
    ): ComputationResult
}


abstract class IndependentOperand : MathExpression() {
    final override val children: List<MathExpression>
        get() = emptyList()

    abstract override fun computeResult(
        context: ExpressionContext
    ): ComputationResult
}


abstract class IndependentOperation : MathExpression() {
    final override val children: List<MathExpression>
        get() = emptyList()

    final override fun computeResult(
        context: ExpressionContext
    ): ComputationResult =
        computeResult()

    protected abstract fun computeResult(): ComputationResult
}


// todo how can we move parent/children logic into operation?
// problem - when we link $this into another object before construction - we can have an error
// todo try with spring context and without it, how much efficiency we will waste with spring context?
abstract class UnaryOperation(
    argument: MathExpression
) : MathExpression() {

    override val children: List<MathExpression>
        get() = listOf(argument)
    val argument: MathExpression
        by TransformableDelegate(this, argument)

    final override fun computeResult(
        context: ExpressionContext
    ): ComputationResult =
        computeResult(argument.compute(context))

    abstract fun computeResult(arg: ComputationResult): ComputationResult
}

abstract class BinaryOperation(
    leftArgument: MathExpression,
    rightArgument: MathExpression
) : MathExpression() {

    override val children: List<MathExpression>
        get() = listOf(leftArgument, rightArgument)
    var leftArgument: MathExpression
        by TransformableDelegate(this, leftArgument)
    var rightArgument: MathExpression
        by TransformableDelegate(this, rightArgument)

    final override fun computeResult(
        context: ExpressionContext
    ): ComputationResult =
        computeResult(leftArgument.compute(context), rightArgument.compute(context))

    abstract fun computeResult(leftVal: ComputationResult, rightVal: ComputationResult): ComputationResult
}