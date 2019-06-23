package com.compute.graph.operations.builders

import com.compute.graph.operations.base.*
import com.compute.graph.operations.builders.interfaces.OperationBuilder
import com.compute.graph.operations.objects.variables.ScalarVariable
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
            ?: ScalarVariable(name)

    override fun buildIndependentOperation(
        name: String
    ): IndependentOperation {
        throw OperationNotSupportedException("Cant buildArgs operations in variable builder")
    }

    override fun buildUnaryOperation(
        name: String,
        argument: MathExpression
    ): UnaryOperation {
        throw OperationNotSupportedException("Cant buildArgs operations in variable builder")
    }

    override fun buildBinaryOperation(
        name: String,
        leftArgument: MathExpression,
        rightArgument: MathExpression
    ): BinaryOperation {
        throw OperationNotSupportedException("Cant buildArgs operations in variable builder")
    }
}