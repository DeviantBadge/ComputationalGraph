package com.compute.graph.operation.objects.constants

import com.compute.graph.operation.base.IndependentOperand
import com.compute.graph.operation.base.IndependentOperation
import com.compute.graph.operation.base.TransformableExpression
import com.compute.graph.operation.interfaces.ExpressionArgs
import java.lang.IllegalArgumentException

open class ScalarConstant(
        private val value: Double
) : IndependentOperand() {

    override fun compute(args: ExpressionArgs): Double {
        return value
    }

    override fun differentiate() {
        TODO("Function \"${javaClass.name}.differentiate\" not implemented")
    }

    override fun toString(): String {
        return value.toString()
    }
}