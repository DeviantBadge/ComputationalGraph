package com.compute.graph.operation.objects.constants

import com.compute.graph.operation.annotations.Constant
import com.compute.graph.operation.base.IndependentOperand
import com.compute.graph.operation.interfaces.ExpressionArgs

@Constant
open class ScalarConstant(
        private val value: Double
) : IndependentOperand() {
    override fun compute(args: ExpressionArgs): Double {
        return value
    }

    override fun differentiate(varName: String, args: ExpressionArgs): Double = 0.0


    override fun toString(): String {
        return value.toString()
    }
}