package com.compute.graph.operations.visitors.execution

import com.compute.graph.operations.objects.BinaryOperation
import com.compute.graph.operations.objects.IndependentOperand
import com.compute.graph.operations.objects.MathExpression
import com.compute.graph.operations.objects.UnaryOperation

/**
 * @Author: evgeny
 * @Date: 13/01/2020
 */
class ExecutionSequenceBuilder(
    target: MathExpression
) {
    private val nodeExecutionSequence: LinkedHashSet<MathExpression> = LinkedHashSet()

    init {
        computeExecutionSequence(target)
    }

    fun getExecutionSequence(): List<MathExpression> = nodeExecutionSequence.toList()

    private fun computeExecutionSequence(step: MathExpression) {
        if(step in nodeExecutionSequence) {
            return
        }
        when (step) {
            is IndependentOperand -> appendNewExecutionNode(step)
            is UnaryOperation -> {
                computeExecutionSequence(step.argument)
                appendNewExecutionNode(step)
            }
            is BinaryOperation -> {
                computeExecutionSequence(step.leftArgument)
                computeExecutionSequence(step.rightArgument)
                appendNewExecutionNode(step)
            }
        }
    }

    private fun appendNewExecutionNode(node: MathExpression) {
        nodeExecutionSequence.add(node)
    }
}