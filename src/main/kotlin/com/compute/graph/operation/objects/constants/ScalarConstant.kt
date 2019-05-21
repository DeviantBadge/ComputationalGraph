package com.compute.graph.operation.objects.constants

import com.compute.graph.operation.base.IndependentOperation
import com.compute.graph.operation.base.TransformableExpression
import com.compute.graph.operation.interfaces.ExpressionArgs
import java.lang.IllegalArgumentException

class ScalarConstant(
        private val value: Double
) : IndependentOperation() {

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