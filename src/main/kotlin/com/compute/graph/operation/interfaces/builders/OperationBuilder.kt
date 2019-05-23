package com.compute.graph.operation.interfaces.builders

import com.compute.graph.operation.base.*

/**
 * @Author: evgeny.vorobyev
 * @Since: 1.0
 * @Version: 1.0
 * @Date:2019-05-23
 */
interface OperationBuilder {
    fun buildIndependentOperation(
            name: String
    ): IndependentOperation

    fun buildIndependentOperand(
            name: String
    ): IndependentOperand

    fun buildUnaryOperation(
            name: String,
            argument: TransformableExpression
    ): UnaryOperation

    fun buildBinaryOperation(
            name: String,
            leftArgument: TransformableExpression,
            rightArgument: TransformableExpression
    ): BinaryOperation

    fun buildTernaryOperation(
            name: String,
            leftArgument: TransformableExpression,
            middleArgument: TransformableExpression,
            rightArgument: TransformableExpression
    ): TernarOperation

    fun buildVectorOperation(
            name: String,
            arguments: MutableList<TransformableExpression>
    ): VectorOperation
}