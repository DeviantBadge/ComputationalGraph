package com.compute.graph.operations.base

import com.compute.graph.operations.interfaces.computers.binary.BinaryOperationProcessor
import com.compute.graph.operations.objects.MathExpression
import com.compute.graph.operations.objects.MathObject
import com.compute.graph.operations.objects.Shape
import com.compute.graph.operations.objects.operands.toMathExpression


class BinaryOperation(
    leftArgument: MathObject,
    rightArgument: MathObject,
    val computer: BinaryOperationProcessor
) : MathExpression() {
    override val shape: Shape = computer.computeShape(leftArgument, rightArgument)
    override val parentExpressions = mutableSetOf<MathExpression>()

    val leftArgument: MathExpression =
        leftArgument.toMathExpression().also { it.addParent(this) }
    val rightArgument: MathExpression =
        rightArgument.toMathExpression().also { it.addParent(this) }

/*
    TODO make it extension function for expressions or special walker (?)
    override fun get(number: Int): MathObject

    override fun computeValue(context: ComputationContext, partly: Boolean): MathObject =
        computer.computeResult(leftArgument.compute(context, partly), rightArgument.compute(context, partly))

    override fun diffForwardValue(diffContext: DifferentiationContext): Gradient {
        val leftDiff =
            computer.computeLeftArgDerivative(leftArgument.compute(diffContext.computationContext), rightArgument.compute(diffContext.computationContext))
        val rightDiff =
            computer.computeRightArgDerivative(leftArgument.compute(diffContext.computationContext), rightArgument.compute(diffContext.computationContext))
        return (leftDiff * leftArgument.diffForward(diffContext) +
            rightDiff * rightArgument.diffForward(diffContext))
    }

    override fun diffBackwardValue(diffContext: DifferentiationContext): Gradient {
        TODO("Function \"${javaClass.name}.diffBackwardValue\" not implemented")
    }
*/
}