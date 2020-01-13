package com.compute.graph.operations.base

import com.compute.graph.operations.interfaces.computers.unary.UnaryOperationProcessor
import com.compute.graph.operations.objects.MathExpression
import com.compute.graph.operations.objects.MathObject
import com.compute.graph.operations.objects.Shape
import com.compute.graph.operations.objects.operands.toMathExpression


// todo how can we move parent/children logic into operation?
// problem - when we link $this into another object before construction - we can have an error
// todo try with spring context and without it, how much efficiency we will waste with spring context?
class UnaryOperation(
    argument: MathObject,
    val computer: UnaryOperationProcessor
) : MathExpression() {
    override val shape: Shape = computer.computeShape(argument)
    override val parentExpressions = mutableSetOf<MathExpression>()

    val argument: MathExpression =
        argument.toMathExpression().also { it.addParent(this) }

    /*
    override fun get(number: Int): TensorExpression =
        TODO("Cant get i-th operation of pure expression")


    override fun computeValue(context: ComputationContext, partly: Boolean): TensorExpression =
        computer.computeResult(argument.compute(context, partly))

    override fun diffForwardValue(diffContext: DifferentiationContext): Gradient =
        (computer.derivative(argument.compute(diffContext.computationContext)) * argument.diffForward(diffContext))

    override fun diffBackwardValue(diffContext: DifferentiationContext): Gradient {
        TODO()
//        diffContext.append(argument, computer.differential(argument.compute(diffContext.computationContext)) as Gradient)
//        return diffContext[this]!!
    }
    */
}