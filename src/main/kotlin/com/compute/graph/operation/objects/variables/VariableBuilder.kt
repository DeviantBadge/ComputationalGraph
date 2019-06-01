package com.compute.graph.operation.objects.variables

import com.compute.graph.operation.base.*
import com.compute.graph.operation.interfaces.builders.OperationBuilder
import javax.naming.OperationNotSupportedException
import kotlin.reflect.KClass

class VariableBuilder : OperationBuilder {
    private var variables: MutableMap<String, IndependentOperand> = hashMapOf()

    override fun <T : MathExpression> build(
        exprType: KClass<T>,
        name: String,
        vararg arguments: Any
    ): T {
        throw OperationNotSupportedException("Cant build operations in variable builder")
    }

    override fun buildIndependentOperand(
        name: String
    ): IndependentOperand =
        variables[name]
            ?: ScalarVariable(name)

    override fun buildIndependentOperation(
        name: String
    ): IndependentOperation {
        throw OperationNotSupportedException("Cant build operations in variable builder")
    }

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

    override fun buildTernaryOperation(
        name: String,
        leftArgument: MathExpression,
        middleArgument: MathExpression,
        rightArgument: MathExpression
    ): TernaryOperation {
        throw OperationNotSupportedException("Cant build operations in variable builder")
    }

    override fun buildVectorOperation(
        name: String,
        arguments: List<MathExpression>
    ): VectorOperation {
        throw OperationNotSupportedException("Cant build operations in variable builder")
    }
}