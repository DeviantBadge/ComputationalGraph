package com.compute.graph.operations.objects

import com.compute.graph.operations.interfaces.computers.binary.BinaryOperationProcessor
import com.compute.graph.operations.interfaces.computers.unary.UnaryOperationProcessor
import com.compute.graph.util.MathObjectPrinter
import com.compute.graph.util.extensions.toMathExpression

/**
 * @Author: evgeny
 * @Date: 2019-07-28
 */
sealed class MathObject {
    abstract val shape: Shape
    override fun toString(): String {
        return MathObjectPrinter.toPrettyString(this)
    }
}

sealed class  AlgebraicType: MathObject() {
    abstract override val shape: AlgebraicShape
}

abstract class  Scalar: AlgebraicType() {
    abstract val value: Double
    abstract override val shape: ScalarShape
}

abstract class  Tensor : AlgebraicType(), Iterable<AlgebraicType> {
    abstract override val shape: TensorShape

    // must throw an exception, when dim is unknown or empty
    abstract operator fun get(number: Int): AlgebraicType
}


sealed class  TechnicalType: MathObject()

abstract class  Gradient: TechnicalType(),
    Map<String, MathObject> {
    abstract override operator fun get(key: String): MathObject

    abstract operator fun set(key: String, value: MathObject): MathObject?
}

// todo create functions
// todo create systems
// todo implement simple operators for it in builder, to avoid some integration problems
// todo implement visualisation
sealed class MathExpression: TechnicalType() {
    /**
     * Each expression can have parents. Storing them in 'parents' set
     */
    abstract val parentExpressions: MutableSet<MathExpression>

    /**
     * Add parent to expression if already not in it
     */
    fun addParent(parent: MathExpression) =
        parentExpressions.add(parent)

    /**
     * Remove parent from expression
     */
    fun removeParent(parent: MathExpression) =
        parentExpressions.remove(parent)

}


class BinaryOperation(
    leftArgument: MathObject,
    rightArgument: MathObject,
    val computer: BinaryOperationProcessor
) : MathExpression() {
    override val shape: Shape = computer.computeShape(leftArgument.shape, rightArgument.shape)
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

sealed class IndependentOperand : MathExpression()

class Constant internal constructor(
    val value: MathObject
) : IndependentOperand() {
    override val parentExpressions: MutableSet<MathExpression> = mutableSetOf()
    override val shape: Shape
        get() = value.shape
}


open class Variable(
    val name: String
) : IndependentOperand() {

    override var shape: Shape = ScalarShape
        protected set

    override val parentExpressions: MutableSet<MathExpression> = mutableSetOf()

    override fun hashCode(): Int {
        return name.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        if (other is Variable) {
            return name == other.name
        }
        return false
    }
}

// todo implement f(g(x,y))
// todo rethink about variables and constants, may be they need separate logic?