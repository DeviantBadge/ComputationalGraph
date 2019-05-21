package com.compute.graph.operation.objects.functions

import com.compute.graph.operation.base.TransformableExpression
import com.compute.graph.operation.base.UnaryOperation
import com.compute.graph.operation.interfaces.ExpressionArgs
import kotlin.math.sin

class SinFunction(
        argument: TransformableExpression
) : UnaryOperation(argument) {

    override fun compute(args: ExpressionArgs): Double {
        return sin(children[0].compute(args))
    }

    override fun differentiate() {
        TODO("Function \"${javaClass.name}.differentiate\" not implemented")
    }
}