package com.compute.graph.operation.base

import com.compute.graph.operation.interfaces.ExpressionContext
import com.compute.graph.operation.objects.TransformableDelegate

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
}


abstract class IndependentOperation : MathExpression() {
    final override val children: List<MathExpression>
        get() = emptyList()
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

    override fun computeResult(
        context: ExpressionContext
    ): ComputationResult {
        return when (val argumentResult = argument.compute(context)) {
            is ScalarComputationResult ->
                compute(argumentResult)
            is VectorComputationResult ->
                compute(argumentResult)
            is MatrixComputationResult ->
                compute(argumentResult)
            is MultipleResult ->
                compute(argumentResult)
        }
    }

    abstract fun compute(arg: ScalarComputationResult): ComputationResult
    fun compute(arg: VectorComputationResult): ComputationResult =
        TODO()

    fun compute(arg: MatrixComputationResult): ComputationResult =
        TODO()

    fun compute(arg: MultipleResult): ComputationResult =
        TODO()
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

    override fun computeResult(
        context: ExpressionContext
    ): ComputationResult {
        val leftRes = leftArgument.compute(context)
        val rightRes = rightArgument.compute(context)

        return when (leftRes) {
            is ScalarComputationResult ->
                when (rightRes) {
                    is ScalarComputationResult ->
                        compute(leftRes, rightRes)
                    is VectorComputationResult ->
                        compute(leftRes, rightRes)
                    is MatrixComputationResult ->
                        compute(leftRes, rightRes)
                    is MultipleResult ->
                        compute(leftRes, rightRes)
                }
            is VectorComputationResult ->
                when (rightRes) {
                    is ScalarComputationResult ->
                        compute(leftRes, rightRes)
                    is VectorComputationResult ->
                        compute(leftRes, rightRes)
                    is MatrixComputationResult ->
                        compute(leftRes, rightRes)
                    is MultipleResult ->
                        compute(leftRes, rightRes)
                }
            is MatrixComputationResult ->
                when (rightRes) {
                    is ScalarComputationResult ->
                        compute(leftRes, rightRes)
                    is VectorComputationResult ->
                        compute(leftRes, rightRes)
                    is MatrixComputationResult ->
                        compute(leftRes, rightRes)
                    is MultipleResult ->
                        compute(leftRes, rightRes)
                }
            is MultipleResult ->
                when (rightRes) {
                    is ScalarComputationResult ->
                        compute(leftRes, rightRes)
                    is VectorComputationResult ->
                        compute(leftRes, rightRes)
                    is MatrixComputationResult ->
                        compute(leftRes, rightRes)
                    is MultipleResult ->
                        compute(leftRes, rightRes)
                }
        }
    }

    abstract fun compute(
        leftArg: ScalarComputationResult,
        rightArg: ScalarComputationResult
    ): ComputationResult

    fun compute(
        leftArg: ScalarComputationResult,
        rightArg: VectorComputationResult
    ): ComputationResult =
        TODO()

    fun compute(
        leftArg: ScalarComputationResult,
        rightArg: MatrixComputationResult
    ): ComputationResult =
        TODO()

    fun compute(
        leftArg: ScalarComputationResult,
        rightArg: MultipleResult
    ): ComputationResult =
        TODO()


    fun compute(
        leftArg: VectorComputationResult,
        rightArg: ScalarComputationResult
    ): ComputationResult =
        TODO()

    fun compute(
        leftArg: VectorComputationResult,
        rightArg: VectorComputationResult
    ): ComputationResult =
        TODO()

    fun compute(
        leftArg: VectorComputationResult,
        rightArg: MatrixComputationResult
    ): ComputationResult =
        TODO()

    fun compute(
        leftArg: VectorComputationResult,
        rightArg: MultipleResult
    ): ComputationResult =
        TODO()


    fun compute(
        leftArg: MatrixComputationResult,
        rightArg: ScalarComputationResult
    ): ComputationResult =
        TODO()

    fun compute(
        leftArg: MatrixComputationResult,
        rightArg: VectorComputationResult
    ): ComputationResult =
        TODO()

    fun compute(
        leftArg: MatrixComputationResult,
        rightArg: MatrixComputationResult
    ): ComputationResult =
        TODO()

    fun compute(
        leftArg: MatrixComputationResult,
        rightArg: MultipleResult
    ): ComputationResult =
        TODO()


    fun compute(
        leftArg: MultipleResult,
        rightArg: ScalarComputationResult
    ): ComputationResult =
        TODO()

    fun compute(
        leftArg: MultipleResult,
        rightArg: VectorComputationResult
    ): ComputationResult =
        TODO()

    fun compute(
        leftArg: MultipleResult,
        rightArg: MatrixComputationResult
    ): ComputationResult =
        TODO()

    fun compute(
        leftArg: MultipleResult,
        rightArg: MultipleResult
    ): ComputationResult =
        TODO()
}