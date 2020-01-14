package com.compute.graph.operations.visitors.differentiation

import com.compute.graph.operations.dsl.operations.binary.operators.plus
import com.compute.graph.operations.dsl.operations.binary.operators.times
import com.compute.graph.operations.interfaces.arguments.ComputationArgs
import com.compute.graph.operations.objects.*
import com.compute.graph.operations.objects.types.GradientImpl
import com.compute.graph.operations.objects.types.ScalarConstant
import com.compute.graph.operations.visitors.execution.ComputationVisitor
import com.compute.graph.operations.visitors.execution.ComputedValues
import com.compute.graph.operations.visitors.execution.ExecutionSequenceBuilder
import com.compute.graph.util.extensions.*

/**
 * @Author: evgeny
 * @Date: 27/12/2019
 */
class BackwardDifferentialVisitor(
    val target: MathExpression,
    val computedValues: ComputedValues,
    val computedDerivatives: ComputedValues,
    executionSequence: List<MathExpression>
) {
    private val result: Gradient = GradientImpl()
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
        preComputeVertexValues(computationArgs)

        for (mathExpression in executionSequence.reversed()) {
            computeVertexValue(mathExpression, computationArgs)
        }
        return result.toSortedMap().toGradient()
    }

    private fun computeVertexValue(vertex: MathExpression, computationArgs: ComputationArgs) {
        if (vertex is Constant) {
            return
        }

        if (vertex.parentExpressions.isEmpty()) {
            computedDerivatives[vertex] = ScalarConstant(1)
        } else {
            computedDerivatives[vertex] = ScalarConstant(0)
        }
        loop_name@
        for (parentExpression in vertex.parentExpressions) {
            when (parentExpression) {
                is IndependentOperand -> continue@loop_name
                is UnaryOperation -> addSubDerivative(vertex, parentExpression, computationArgs)
                is BinaryOperation -> addSubDerivative(vertex, parentExpression, computationArgs)
            }
        }

        if (vertex is Variable) {
            result[vertex.name] = result[vertex.name] + computedDerivatives[vertex]
        }
    }

    private fun addSubDerivative(vertex: MathExpression, parentExpression: UnaryOperation, computationArgs: ComputationArgs) {
        computedDerivatives[vertex] = computedDerivatives[vertex] +
            computedDerivatives[parentExpression] * parentExpression.derivative(computedValues[parentExpression.argument])
    }

    private fun addSubDerivative(vertex: MathExpression, parentExpression: BinaryOperation, computationArgs: ComputationArgs) {
        if (parentExpression.leftArgument == vertex) {
            computedDerivatives[vertex] = computedDerivatives[vertex] + computedDerivatives[parentExpression] *
                parentExpression.leftArgDerivative(computedValues[parentExpression.leftArgument], computedValues[parentExpression.rightArgument])
        }
        if (parentExpression.rightArgument == vertex) {
            computedDerivatives[vertex] = computedDerivatives[vertex] + computedDerivatives[parentExpression] *
                parentExpression.rightArgDerivative(computedValues[parentExpression.leftArgument], computedValues[parentExpression.rightArgument])
        }
    }

    private fun preComputeVertexValues(computationArgs: ComputationArgs) {
        val computationVisitor = ComputationVisitor(target, computedValues, executionSequence)
        computationVisitor.compute(computationArgs)
        computedValues.putAll(computationVisitor.computedValues)

    }
}