package com.compute.graph.operations.objects

import com.compute.graph.util.MathObjectPrinter

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
abstract class MathExpression: TechnicalType() {
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