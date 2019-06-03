package com.compute.graph.operation.objects.variables

import com.compute.graph.operation.annotations.Variable
import com.compute.graph.operation.base.ComputationResult
import com.compute.graph.operation.base.IndependentOperand
import com.compute.graph.operation.base.MultipleResult
import com.compute.graph.operation.interfaces.ExpressionArgs
import com.compute.graph.operation.interfaces.ExpressionContext
import java.lang.IllegalArgumentException

@Variable
class ScalarVariable(
    private val name: String
) : IndependentOperand() {

    override fun computeResult(context: ExpressionContext): ComputationResult =
        context[name] ?: throw IllegalArgumentException("No argument value found for variable $name in $context")

    override fun differentiateForward(args: ExpressionArgs): MultipleResult {
        TODO("Function \"${javaClass.name}.differentiateForward\" not implemented")
    }

    override fun differentiateBackward(args: ExpressionArgs): MultipleResult {
        TODO("Function \"${javaClass.name}.differentiateBackward\" not implemented")
    }

    override fun toString(): String {
        return name
    }
}

// todo implement f(g(x,y))
// todo rethink about variables and constants, may be they need separate logic?
// todo how to implement different return/input types?