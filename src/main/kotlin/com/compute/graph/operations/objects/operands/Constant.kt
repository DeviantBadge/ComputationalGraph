package com.compute.graph.operations.objects.operands

import com.compute.graph.operations.base.IndependentOperand
import com.compute.graph.operations.objects.MathExpression
import com.compute.graph.operations.objects.MathObject
import com.compute.graph.operations.objects.Shape

/**
 * @Author: evgeny
 * @Date: 09/01/2020
 */
class Constant internal constructor(
    val value: MathObject
) : IndependentOperand() {
    override val parentExpressions: MutableSet<MathExpression> = mutableSetOf()
    override val shape: Shape
        get() = value.shape
}

fun MathObject.toMathExpression(): MathExpression =
    this as? MathExpression ?: Constant(this)