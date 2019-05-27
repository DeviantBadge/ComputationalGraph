package com.compute.graph.operation.objects.variables

import com.compute.graph.operation.base.BinaryOperation
import com.compute.graph.operation.base.IndependentOperand
import com.compute.graph.operation.base.IndependentOperation
import com.compute.graph.operation.base.MathExpression
import com.compute.graph.operation.base.TernaryOperation
import com.compute.graph.operation.base.UnaryOperation
import com.compute.graph.operation.base.VectorOperation
import com.compute.graph.operation.base.builders.BaseBuilder
import com.compute.graph.operation.interfaces.builders.OperationBuilder
import com.compute.graph.operation.objects.constants.ScalarConstant
import javax.naming.OperationNotSupportedException
import kotlin.reflect.KClass

class VariableBuilder: OperationBuilder {
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