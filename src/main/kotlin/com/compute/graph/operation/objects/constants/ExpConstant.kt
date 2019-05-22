package com.compute.graph.operation.objects.constants

import com.compute.graph.operation.base.IndependentOperand
import com.compute.graph.operation.base.IndependentOperation
import com.compute.graph.operation.base.TransformableExpression
import com.compute.graph.operation.interfaces.ExpressionArgs
import java.lang.IllegalArgumentException
import kotlin.math.E
import kotlin.math.PI

class ExpConstant : ScalarConstant(E) {
    companion object {
        val names = listOf("e", "exp")
    }

    override fun differentiate() {
        TODO("Function \"${javaClass.name}.differentiate\" not implemented")
    }

    override fun toString(): String {
        return "e"
    }
}
