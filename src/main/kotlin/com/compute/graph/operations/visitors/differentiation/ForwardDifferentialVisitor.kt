package com.compute.graph.operations.visitors.differentiation

import com.compute.graph.operations.dsl.operations.binary.operators.plus
import com.compute.graph.operations.dsl.operations.binary.operators.times
import com.compute.graph.operations.interfaces.arguments.ComputationArgs
import com.compute.graph.operations.objects.*
import com.compute.graph.operations.objects.types.GradientImpl
import com.compute.graph.operations.objects.types.ScalarConstant
import com.compute.graph.operations.visitors.execution.ComputedValues
import com.compute.graph.operations.visitors.execution.ExecutionSequenceBuilder
import com.compute.graph.util.extensions.*

/**
 * @Author: evgeny
 * @Date: 27/12/2019
 */
class ForwardDifferentialVisitor(
    val target: MathExpression,
    val computedValues: ComputedValues,
    val computedDerivatives: ComputedValues,
    executionSequence: List<MathExpression>
) {
    private val executionSequence: List<MathExpression> = if (executionSequence.isNotEmpty()) {
        executionSequence
    } else {
        ExecutionSequenceBuilder(target).getExecutionSequence()
    }

    constructor(
        target: MathObject,
        computedValues: MutableMap<MathExpression, MathObject> = mutableMapOf(),
        computedDerivatives: MutableMap<MathExpression, MathObject> = mutableMapOf(),
        executionSequence: List<MathExpression> = listOf()
    ) : this(target.toMathExpression(), ComputedValues(computedValues), ComputedValues(computedDerivatives), executionSequence)

    fun compute(computationArgs: ComputationArgs): MathObject {
        for (mathExpression in executionSequence) {
            computeVertexValue(mathExpression, computationArgs)
        }
        return computedDerivatives[target]
    }

    private fun computeVertexValue(vertex: MathExpression, computationArgs: ComputationArgs) {
        when (vertex) {
            is Constant -> computeVertexValue(vertex, computationArgs)
            is Variable -> computeVertexValue(vertex, computationArgs)
            is UnaryOperation -> computeVertexValue(vertex, computationArgs)
            is BinaryOperation -> computeVertexValue(vertex, computationArgs)
        }
    }

    private fun computeVertexValue(vertex: Constant, computationArgs: ComputationArgs) {
        computedValues[vertex] = vertex.value
        computedDerivatives[vertex] = GradientImpl()
    }

    private fun computeVertexValue(vertex: Variable, computationArgs: ComputationArgs) {
        computedValues[vertex] = computationArgs[vertex.name] ?: vertex
        computedDerivatives[vertex] = GradientImpl(vertex.name to ScalarConstant(1))
    }

    private fun computeVertexValue(vertex: UnaryOperation, computationArgs: ComputationArgs) {
        if (vertex.argument !in computedValues || vertex.argument !in computedDerivatives) {
            computeVertexValue(vertex.argument, computationArgs)
        }
        computedValues[vertex] = vertex.compute(computedValues[vertex.argument])
        computedDerivatives[vertex] = vertex.derivative(computedValues[vertex.argument]) *
            computedDerivatives[vertex.argument]
    }

    private fun computeVertexValue(vertex: BinaryOperation, computationArgs: ComputationArgs) {
        if (vertex.leftArgument !in computedValues || vertex.leftArgument !in computedDerivatives) {
            computeVertexValue(vertex.leftArgument, computationArgs)
        }
        if (vertex.rightArgument !in computedValues || vertex.rightArgument !in computedDerivatives) {
            computeVertexValue(vertex.rightArgument, computationArgs)
        }
        computedValues[vertex] =
            vertex.compute(
                computedValues[vertex.leftArgument],
                computedValues[vertex.rightArgument]
            )
        computedDerivatives[vertex] =
            vertex.leftArgDerivative(
                computedValues[vertex.leftArgument],
                computedValues[vertex.rightArgument]
            ) * computedDerivatives[vertex.leftArgument] +
                vertex.rightArgDerivative(
                    computedValues[vertex.leftArgument],
                    computedValues[vertex.rightArgument]
                ) * computedDerivatives[vertex.rightArgument]
    }
}
