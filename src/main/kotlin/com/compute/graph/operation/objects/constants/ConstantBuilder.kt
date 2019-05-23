package com.compute.graph.operation.objects.constants

import com.compute.graph.operation.base.*
import com.compute.graph.operation.interfaces.builders.OperationBuilder
import com.compute.graph.operation.interfaces.builders.OperationRegistry
import javax.naming.OperationNotSupportedException

/**
 * <p>Description:</P>
 * <p>Company:Alibaba</p>
 * @Author: evgeny.vorobyev
 * @Since: 1.0
 * @Version:1.0,Date:2019-05-21
 */
object ConstantBuilder: OperationRegistry, OperationBuilder {
    override val registered: MutableMap<String, Class<out TransformableExpression>>
        get() = hashMapOf()

    override fun buildIndependentOperation(
            name: String
    ): IndependentOperation {
        throw OperationNotSupportedException("Cant build operations in constant builder")
    }

    override fun buildIndependentOperand(
            name: String
    ): IndependentOperand {
        TODO("Function \"${javaClass.name}.buildIndependentOperand\" not implemented")
    }

    override fun buildUnaryOperation(
            name: String,
            argument: TransformableExpression
    ): UnaryOperation {
        throw OperationNotSupportedException("Cant build operations in constant builder")
    }

    override fun buildBinaryOperation(
            name: String,
            leftArgument: TransformableExpression,
            rightArgument: TransformableExpression
    ): BinaryOperation {
        throw OperationNotSupportedException("Cant build operations in constant builder")
    }

    override fun buildTernaryOperation(
            name: String,
            leftArgument: TransformableExpression,
            middleArgument: TransformableExpression,
            rightArgument: TransformableExpression
    ): TernarOperation {
        throw OperationNotSupportedException("Cant build operations in constant builder")
    }

    override fun buildVectorOperation(
            name: String,
            arguments: MutableList<TransformableExpression>
    ): VectorOperation {
        throw OperationNotSupportedException("Cant build operations in constant builder")
    }
}