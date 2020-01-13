package com.compute.graph.operations.objects.operands

import com.compute.graph.operations.base.IndependentOperand
import com.compute.graph.operations.objects.MathExpression
import com.compute.graph.operations.objects.Shape
import com.compute.graph.operations.objects.UnknownShape

open class Variable(
    val name: String
) : IndependentOperand() {

    override var shape: Shape = UnknownShape
        protected set

    override val parentExpressions: MutableSet<MathExpression> = mutableSetOf()


    override fun toString(): String {
        return name
    }

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