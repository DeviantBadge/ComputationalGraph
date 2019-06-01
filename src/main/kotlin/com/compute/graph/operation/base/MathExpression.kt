package com.compute.graph.operation.base

import com.compute.graph.operation.interfaces.ExpressionArgs
import com.compute.graph.operation.objects.TransformableDelegate
import com.compute.graph.operation.objects.arguments.ComputationContext

sealed class MathExpression
    : TransformableExpression() {
    override fun compute(
        context: ComputationContext
    ): ComputationResult =
        context[this] ?: computeResult(context).also { context[this] = it }

    protected abstract fun computeResult(
        args: ComputationContext
    ): ComputationResult
}

abstract class IndependentOperand : MathExpression() {
    final override val children: List<MathExpression>
        get() = emptyList()
}

abstract class IndependentOperation : MathExpression() {
    final override val children: List<MathExpression>
        get() = emptyList()
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

    override fun compute(args: ExpressionArgs): ComputationResult {
        when (argument) {
            is S
        }
    }

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

// todo may be remove it?
abstract class TernaryOperation(
    leftArgument: MathExpression,
    middleArgument: MathExpression,
    rightArgument: MathExpression
) : MathExpression() {
    override val children: List<MathExpression>
        get() = listOf(leftArgument, middleArgument, rightArgument)


    var leftArgument: MathExpression
        by TransformableDelegate(this, leftArgument)
    var middleArgument: MathExpression
        by TransformableDelegate(this, middleArgument)
    var rightArgument: MathExpression
        by TransformableDelegate(this, rightArgument)
}