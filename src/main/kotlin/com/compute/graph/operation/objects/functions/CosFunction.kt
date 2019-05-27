package com.compute.graph.operation.objects.functions

import com.compute.graph.operation.annotations.Function
import com.compute.graph.operation.base.MathExpression
import com.compute.graph.operation.base.UnaryOperation
import com.compute.graph.operation.interfaces.ExpressionArgs
import kotlin.math.cos
import kotlin.math.sin

@Function("cos")
class CosFunction(
        argument: MathExpression
) : UnaryOperation(argument) {
    override fun compute(args: ExpressionArgs): Double {
        return cos(children[0].compute(args))
    }

    override fun differentiate(varName: String, args: ExpressionArgs): Double =
            -sin(argument.compute(args)) * argument.differentiate(varName, args)
}