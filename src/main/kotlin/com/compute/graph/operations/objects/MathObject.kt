package com.compute.graph.operations.objects

import com.compute.graph.operations.interfaces.core.binary.BinaryOperationCore
import com.compute.graph.operations.interfaces.core.unary.UnaryOperationCore
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
     * todo implement scope of modifications
     */
    val parentExpressions: MutableSet<MathExpression> = mutableSetOf<MathExpression>()

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
    val specification: BinaryOperationCore
) : MathExpression() {
    override val shape: Shape = specification.computeShape(leftArgument.shape, rightArgument.shape)

    val leftArgument: MathExpression =
        leftArgument.toMathExpression().also { it.addParent(this) }
    val rightArgument: MathExpression =
        rightArgument.toMathExpression().also { it.addParent(this) }

/*
    TODO make it extension function for expressions or special walker (?)
    override fun get(number: Int): MathObject
*/
}

// todo how can we move parent/children logic into operation?
// problem - when we link $this into another object before construction - we can have an error
// todo try with spring context and without it, how much efficiency we will waste with spring context?
class UnaryOperation(
    argument: MathObject,
    val specification: UnaryOperationCore
) : MathExpression() {
    override val shape: Shape = specification.computeShape(argument.shape)

    val argument: MathExpression =
        argument.toMathExpression().also { it.addParent(this) }

    /*
    override fun get(number: Int): TensorExpression =
        TODO("Cant get i-th operation of pure expression")
    */
}

sealed class IndependentOperand : MathExpression()

class Constant internal constructor(
    val value: MathObject
) : IndependentOperand() {
    override val shape: Shape
        get() = value.shape
}


open class Variable(
    val name: String,
    shape: Shape = ScalarShape // todo here must be MathExpressionShape
) : IndependentOperand() {

    override var shape: Shape = shape
        protected set

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