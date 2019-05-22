package com.compute.graph.operation.objects.constants

import com.compute.graph.operation.base.IndependentOperand
import com.compute.graph.operation.base.IndependentOperation
import com.compute.graph.operation.base.TransformableExpression
import com.compute.graph.operation.interfaces.ExpressionArgs
import java.lang.IllegalArgumentException
import kotlin.math.PI

class PiConstant : ScalarConstant(PI) {
    companion object {
        val names = listOf("pi", "Pi")
    }

    override fun differentiate() {
        TODO("Function \"${javaClass.name}.differentiate\" not implemented")
    }

    override fun toString(): String {
        return "π"
    }
}