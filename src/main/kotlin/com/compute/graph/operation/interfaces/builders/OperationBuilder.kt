package com.compute.graph.operation.interfaces.builders

import com.compute.graph.operation.base.*
import com.compute.graph.operation.base.properties.AssociationType
import kotlin.reflect.KClass

/**
 * @Author: evgeny.vorobyev
 * @Since: 1.0
 * @Version: 1.0
 * @Date:2019-05-23
 */
interface OperationBuilder {
    fun <T : MathExpression> build(
        exprType: KClass<T>,
        name: String,
        vararg arguments: Any
    ): T

    fun buildIndependentOperand(
        name: String
    ): IndependentOperand =
        build(IndependentOperand::class, name)

    fun buildIndependentOperation(
        name: String
    ): IndependentOperation =
        build(IndependentOperation::class, name)

    fun buildUnaryOperation(
        name: String,
        argument: MathExpression
    ): UnaryOperation =
        build(UnaryOperation::class, name, argument)

    fun buildBinaryOperation(
        name: String,
        leftArgument: MathExpression,
        rightArgument: MathExpression
    ): BinaryOperation =
        build(BinaryOperation::class, name, leftArgument, rightArgument)
}