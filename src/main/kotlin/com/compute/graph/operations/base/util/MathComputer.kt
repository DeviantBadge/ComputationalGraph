package com.compute.graph.operations.base.util

import com.compute.graph.operations.base.*

/**
 * @Author: evgeny
 * @Since: 1.0
 * @Version: 1.0
 * @Date: 2019-06-04
 */
abstract class UnaryComputer {
    final fun compute(
        argVal: ComputationResult
    ): ComputationResult =
        when (argVal) {
            is ScalarComputationResult ->
                compute(argVal)
            is VectorComputationResult ->
                compute(argVal)
            is MatrixComputationResult ->
                compute(argVal)
            is MultipleResult ->
                compute(argVal)
            is ExpressionComputationResult ->
                compute(argVal)
        }

    protected abstract fun compute(arg: ScalarComputationResult): ComputationResult

    protected fun compute(arg: VectorComputationResult): ComputationResult =
        TODO()

    protected fun compute(arg: MatrixComputationResult): ComputationResult =
        TODO()

    protected fun compute(arg: MultipleResult): ComputationResult =
        TODO()

    protected fun compute(arg: ExpressionComputationResult): ComputationResult =
        TODO()
}


abstract class BinaryComputer {

    final fun compute(
        leftVal: ComputationResult,
        rightVal: ComputationResult
    ): ComputationResult =
        when (leftVal) {
            is ScalarComputationResult ->
                when (rightVal) {
                    is ScalarComputationResult ->
                        compute(leftVal, rightVal)
                    is VectorComputationResult ->
                        compute(leftVal, rightVal)
                    is MatrixComputationResult ->
                        compute(leftVal, rightVal)
                    is MultipleResult ->
                        compute(leftVal, rightVal)
                    is ExpressionComputationResult ->
                        compute(leftVal, rightVal)
                }
            is VectorComputationResult ->
                when (rightVal) {
                    is ScalarComputationResult ->
                        compute(leftVal, rightVal)
                    is VectorComputationResult ->
                        compute(leftVal, rightVal)
                    is MatrixComputationResult ->
                        compute(leftVal, rightVal)
                    is MultipleResult ->
                        compute(leftVal, rightVal)
                    is ExpressionComputationResult ->
                        compute(leftVal, rightVal)
                }
            is MatrixComputationResult ->
                when (rightVal) {
                    is ScalarComputationResult ->
                        compute(leftVal, rightVal)
                    is VectorComputationResult ->
                        compute(leftVal, rightVal)
                    is MatrixComputationResult ->
                        compute(leftVal, rightVal)
                    is MultipleResult ->
                        compute(leftVal, rightVal)
                    is ExpressionComputationResult ->
                        compute(leftVal, rightVal)
                }
            is MultipleResult ->
                when (rightVal) {
                    is ScalarComputationResult ->
                        compute(leftVal, rightVal)
                    is VectorComputationResult ->
                        compute(leftVal, rightVal)
                    is MatrixComputationResult ->
                        compute(leftVal, rightVal)
                    is MultipleResult ->
                        compute(leftVal, rightVal)
                    is ExpressionComputationResult ->
                        compute(leftVal, rightVal)
                }
            is ExpressionComputationResult ->
                when (rightVal) {
                    is ScalarComputationResult ->
                        compute(leftVal, rightVal)
                    is VectorComputationResult ->
                        compute(leftVal, rightVal)
                    is MatrixComputationResult ->
                        compute(leftVal, rightVal)
                    is MultipleResult ->
                        compute(leftVal, rightVal)
                    is ExpressionComputationResult ->
                        compute(leftVal, rightVal)
                }
        }


    protected abstract fun compute(
        leftArg: ScalarComputationResult,
        rightArg: ScalarComputationResult
    ): ComputationResult

    protected fun compute(
        leftArg: ScalarComputationResult,
        rightArg: VectorComputationResult
    ): ComputationResult =
        TODO()

    protected fun compute(
        leftArg: ScalarComputationResult,
        rightArg: MatrixComputationResult
    ): ComputationResult =
        TODO()

    protected fun compute(
        leftArg: ScalarComputationResult,
        rightArg: MultipleResult
    ): ComputationResult =
        TODO()

    protected fun compute(
        leftArg: ScalarComputationResult,
        rightArg: ExpressionComputationResult
    ): ComputationResult =
        TODO()


    protected fun compute(
        leftArg: VectorComputationResult,
        rightArg: ScalarComputationResult
    ): ComputationResult =
        TODO()

    protected fun compute(
        leftArg: VectorComputationResult,
        rightArg: VectorComputationResult
    ): ComputationResult =
        TODO()

    protected fun compute(
        leftArg: VectorComputationResult,
        rightArg: MatrixComputationResult
    ): ComputationResult =
        TODO()

    protected fun compute(
        leftArg: VectorComputationResult,
        rightArg: MultipleResult
    ): ComputationResult =
        TODO()

    protected fun compute(
        leftArg: VectorComputationResult,
        rightArg: ExpressionComputationResult
    ): ComputationResult =
        TODO()


    protected fun compute(
        leftArg: MatrixComputationResult,
        rightArg: ScalarComputationResult
    ): ComputationResult =
        TODO()

    protected fun compute(
        leftArg: MatrixComputationResult,
        rightArg: VectorComputationResult
    ): ComputationResult =
        TODO()

    protected fun compute(
        leftArg: MatrixComputationResult,
        rightArg: MatrixComputationResult
    ): ComputationResult =
        TODO()

    protected fun compute(
        leftArg: MatrixComputationResult,
        rightArg: MultipleResult
    ): ComputationResult =
        TODO()

    protected fun compute(
        leftArg: MatrixComputationResult,
        rightArg: ExpressionComputationResult
    ): ComputationResult =
        TODO()


    protected fun compute(
        leftArg: MultipleResult,
        rightArg: ScalarComputationResult
    ): ComputationResult =
        TODO()

    protected fun compute(
        leftArg: MultipleResult,
        rightArg: VectorComputationResult
    ): ComputationResult =
        TODO()

    protected fun compute(
        leftArg: MultipleResult,
        rightArg: MatrixComputationResult
    ): ComputationResult =
        TODO()

    protected fun compute(
        leftArg: MultipleResult,
        rightArg: MultipleResult
    ): ComputationResult =
        TODO()

    protected fun compute(
        leftArg: MultipleResult,
        rightArg: ExpressionComputationResult
    ): ComputationResult =
        TODO()


    protected fun compute(
        leftArg: ExpressionComputationResult,
        rightArg: ScalarComputationResult
    ): ComputationResult =
        TODO()

    protected fun compute(
        leftArg: ExpressionComputationResult,
        rightArg: VectorComputationResult
    ): ComputationResult =
        TODO()

    protected fun compute(
        leftArg: ExpressionComputationResult,
        rightArg: MatrixComputationResult
    ): ComputationResult =
        TODO()

    protected fun compute(
        leftArg: ExpressionComputationResult,
        rightArg: MultipleResult
    ): ComputationResult =
        TODO()

    protected fun compute(
        leftArg: ExpressionComputationResult,
        rightArg: ExpressionComputationResult
    ): ComputationResult =
        TODO()
}

