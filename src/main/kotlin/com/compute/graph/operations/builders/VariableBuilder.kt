package com.compute.graph.operations.builders

import com.compute.graph.operations.base.*
import com.compute.graph.operations.builders.interfaces.OperationBuilder
import com.compute.graph.operations.objects.MathExpression
import com.compute.graph.operations.objects.operands.Variable
import javax.naming.OperationNotSupportedException
import kotlin.reflect.KClass

class VariableBuilder : OperationBuilder {
    private var variables: MutableMap<String, IndependentOperand> = hashMapOf()

    override fun <T : MathExpression> build(
        exprType: KClass<T>,
        name: String,
        vararg arguments: Any
    ): T {
        throw OperationNotSupportedException("Cant buildArgs operations in variable builder")
    }

    override fun buildIndependentOperand(
        name: String
    ): IndependentOperand =
        variables[name]
            ?: Variable(name)

    override fun buildUnaryOperation(
        name: String,
        argument: MathExpression
    ): UnaryOperation {
        throw OperationNotSupportedException("Cant build operations in variable builder")
    }

    override fun buildBinaryOperation(
        name: String,
        leftArgument: MathExpression,
        rightArgument: MathExpression
    ): BinaryOperation {
        throw OperationNotSupportedException("Cant build operations in variable builder")
    }
}