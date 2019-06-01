package com.compute.graph.operation.objects.constants

import com.compute.graph.operation.base.BinaryOperation
import com.compute.graph.operation.base.IndependentOperand
import com.compute.graph.operation.base.IndependentOperation
import com.compute.graph.operation.base.MathExpression
import com.compute.graph.operation.base.TernaryOperation
import com.compute.graph.operation.base.UnaryOperation
import com.compute.graph.operation.base.VectorOperation
import com.compute.graph.operation.base.builders.BaseBuilder
import javax.naming.OperationNotSupportedException
import kotlin.reflect.KClass

/**
 * <p>Description:</P>
 * <p>Company:Alibaba</p>
 * @Author: evgeny.vorobyev
 * @Since: 1.0
 * @Version:1.0,Date:2019-05-21
 */

object ConstantBuilder : BaseBuilder() {

    override fun buildIndependentOperation(
        name: String
    ): IndependentOperation {
        throw OperationNotSupportedException("Cant build operations in constants builder")
    }

    override fun buildIndependentOperand(
        name: String
    ): IndependentOperand {
        name.toDoubleOrNull()?.let {
            return ScalarConstant(it)
        }
        return super.buildIndependentOperand(name)
    }

    override fun buildUnaryOperation(
        name: String,
        argument: MathExpression
    ): UnaryOperation {
        throw OperationNotSupportedException("Cant build operations in constants builder")
    }

    override fun buildBinaryOperation(
        name: String,
        leftArgument: MathExpression,
        rightArgument: MathExpression
    ): BinaryOperation {
        throw OperationNotSupportedException("Cant build operations in constants builder")
    }

    override fun buildTernaryOperation(
        name: String,
        leftArgument: MathExpression,
        middleArgument: MathExpression,
        rightArgument: MathExpression
    ): TernaryOperation {
        throw OperationNotSupportedException("Cant build operations in constants builder")
    }

    override fun buildVectorOperation(
        name: String,
        arguments: List<MathExpression>
    ): VectorOperation {
        throw OperationNotSupportedException("Cant build operations in constants builder")
    }

    override fun isRegistered(name: String): Boolean {
        return (name.toDoubleOrNull() != null) || super.isRegistered(name)
    }
}
