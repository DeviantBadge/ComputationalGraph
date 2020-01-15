package com.compute.graph.operations.visitors.differentiation

import com.compute.graph.operations.dsl.operations.binary.operators.plus
import com.compute.graph.operations.dsl.operations.binary.operators.times
import com.compute.graph.operations.interfaces.arguments.ComputationArgs
import com.compute.graph.operations.objects.*
import com.compute.graph.operations.objects.arguments.ComputationArgsImpl
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

    fun compute(
        computationArgs: ComputationArgs = ComputationArgsImpl(),
        vararg diffVariables: Variable
    ): MathObject {
        for (mathExpression in executionSequence) {
            computeVertexValue(mathExpression, computationArgs, *diffVariables)
        }
        return computedDerivatives[target]
    }

    private fun computeVertexValue(
        vertex: MathExpression,
        computationArgs: ComputationArgs,
        vararg diffVariables: Variable
    ) {
        when (vertex) {
            is Constant -> computeVertexValue(vertex, computationArgs, *diffVariables)
            is Variable -> computeVertexValue(vertex, computationArgs, *diffVariables)
            is UnaryOperation -> computeVertexValue(vertex, computationArgs, *diffVariables)
            is BinaryOperation -> computeVertexValue(vertex, computationArgs, *diffVariables)
        }
    }

    private fun computeVertexValue(
        vertex: Constant,
        computationArgs: ComputationArgs,
        vararg diffVariables: Variable
    ) {
        computedValues[vertex] = vertex.value
        computedDerivatives[vertex] = GradientImpl()
    }

    private fun computeVertexValue(
        vertex: Variable,
        computationArgs: ComputationArgs,
        vararg diffVariables: Variable
    ) {
        computedValues[vertex] = computationArgs[vertex.name] ?: vertex
        if (diffVariables.isEmpty() || vertex in diffVariables){
            computedDerivatives[vertex] = GradientImpl(vertex.name to ScalarConstant(1))
        }
    }

    private fun computeVertexValue(
        vertex: UnaryOperation,
        computationArgs: ComputationArgs,
        vararg diffVariables: Variable
    ) {
        if (vertex.argument !in computedValues || vertex.argument !in computedDerivatives) {
            computeVertexValue(vertex.argument, computationArgs, *diffVariables)
        }
        computedValues[vertex] = vertex.compute(computedValues[vertex.argument])
        computedDerivatives[vertex] = vertex.derivative(computedValues[vertex.argument]) *
            computedDerivatives[vertex.argument]
    }

    private fun computeVertexValue(
        vertex: BinaryOperation,
        computationArgs: ComputationArgs,
        vararg diffVariables: Variable
    ) {
        if (vertex.leftArgument !in computedValues || vertex.leftArgument !in computedDerivatives) {
            computeVertexValue(vertex.leftArgument, computationArgs, *diffVariables)
        }
        if (vertex.rightArgument !in computedValues || vertex.rightArgument !in computedDerivatives) {
            computeVertexValue(vertex.rightArgument, computationArgs, *diffVariables)
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
