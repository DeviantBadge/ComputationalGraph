package com.compute.graph.operation.objects.operators

import com.compute.graph.operation.annotations.Operator
import com.compute.graph.operation.base.BinaryOperation
import com.compute.graph.operation.base.MathExpression
import com.compute.graph.operation.base.UnaryOperation
import com.compute.graph.operation.interfaces.ExpressionArgs
import org.apache.commons.math3.special.Gamma

@Operator("!")
class FactorialOp(
        argument: MathExpression
) : UnaryOperation(argument) {
    // todo may be produce differential in another class, that can remember values?
    override fun differentiate(varName: String, args: ExpressionArgs): Double {
        TODO("Function \"${javaClass.name}.differentiate\" not implemented")
    }

    // todo create extension for execution result, that will handle operations
    // todo validation
    override fun compute(args: ExpressionArgs): Double {
        return Gamma.gamma(argument.compute(args) + 1)
    }
}
