package com.compute.graph.operations.objects.variables

import com.compute.graph.operations.annotations.Variable
import com.compute.graph.operations.base.ComputationResult
import com.compute.graph.operations.base.IndependentOperand
import com.compute.graph.operations.base.MultipleResult
import com.compute.graph.operations.interfaces.ExpressionArgs
import com.compute.graph.operations.interfaces.ExpressionContext
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