package com.compute.graph.operations.visitors.execution

import com.compute.graph.operations.interfaces.arguments.ComputationArgs
import com.compute.graph.operations.objects.*
import com.compute.graph.operations.objects.arguments.ComputationArgsImpl
import com.compute.graph.util.extensions.compute
import com.compute.graph.util.extensions.toMathExpression

/**
 * @Author: evgeny
 * @Date: 27/12/2019
 * todo make interface and clean the code
 */
class ComputationVisitor(
    private val target: MathExpression,
    val computedValues: ComputedValues,
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
        executionSequence: List<MathExpression> = listOf()
    ) : this(target.toMathExpression(), ComputedValues(computedValues), executionSequence)

    fun compute(computationArgs: ComputationArgs = ComputationArgsImpl()): MathObject {
        for (mathExpression in executionSequence) {
            computeVertexValue(mathExpression, computationArgs)
        }
        return computedValues[target]
    }

    private fun computeVertexValue(vertex: MathExpression, computationArgs: ComputationArgs) {
        when (vertex) {
            in computedValues -> return
            is Constant -> computeVertexValue(vertex, computationArgs)
            is Variable -> computeVertexValue(vertex, computationArgs)
            is UnaryOperation -> computeVertexValue(vertex, computationArgs)
            is BinaryOperation -> computeVertexValue(vertex, computationArgs)
        }
    }

    private fun computeVertexValue(vertex: Constant, computationArgs: ComputationArgs) {
        computedValues[vertex] = vertex.value
    }

    private fun computeVertexValue(vertex: Variable, computationArgs: ComputationArgs) {
        computedValues[vertex] = computationArgs[vertex.name] ?: vertex
    }

    private fun computeVertexValue(vertex: UnaryOperation, computationArgs: ComputationArgs) {
        if (vertex.argument !in  computedValues) {
            computeVertexValue(vertex.argument, computationArgs)
        }
        computedValues[vertex] = vertex.compute(computedValues[vertex.argument])
    }

    private fun computeVertexValue(vertex: BinaryOperation, computationArgs: ComputationArgs) {
        if (vertex.leftArgument !in  computedValues) {
            computeVertexValue(vertex.leftArgument, computationArgs)
        }
        if (vertex.rightArgument !in  computedValues) {
            computeVertexValue(vertex.rightArgument, computationArgs)
        }
        computedValues[vertex] = vertex.compute(
            computedValues[vertex.leftArgument],
            computedValues[vertex.rightArgument]
        )
    }
}