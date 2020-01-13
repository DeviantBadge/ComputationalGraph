package com.compute.graph.operations.builders

import com.compute.graph.operations.base.BinaryOperation
import com.compute.graph.operations.base.IndependentOperand
import com.compute.graph.operations.objects.MathExpression
import com.compute.graph.operations.base.UnaryOperation
import javax.naming.OperationNotSupportedException

/**
 * <p>Description:</P>
 * <p>Company:Alibaba</p>
 * @Author: evgeny.vorobyev
 * @Since: 1.0
 * @Version:1.0,Date:2019-05-21
 */

object ConstantBuilder : BaseBuilder() {

    override fun buildIndependentOperand(
        name: String
    ): IndependentOperand {
        TODO()
    }

    override fun buildUnaryOperation(
        name: String,
        argument: MathExpression
    ): UnaryOperation {
        throw OperationNotSupportedException("Cant buildArgs operations in constants builder")
    }

    override fun buildBinaryOperation(
        name: String,
        leftArgument: MathExpression,
        rightArgument: MathExpression
    ): BinaryOperation {
        throw OperationNotSupportedException("Cant buildArgs operations in constants builder")
    }

    override fun isRegistered(name: String): Boolean {
        return (name.toDoubleOrNull() != null) || super.isRegistered(name)
    }
}
