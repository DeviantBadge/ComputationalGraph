package com.compute.graph.operation.objects.variables

import com.compute.graph.operation.annotations.Variable
import com.compute.graph.operation.base.IndependentOperand
import com.compute.graph.operation.interfaces.ExpressionArgs

@Variable
class ScalarVariable(
    private val name: String
) : IndependentOperand() {

    override fun compute(args: ExpressionArgs): Double {
        return args[name] ?: throw IllegalArgumentException("Arguments do not contain variable with name $name. " +
            "It contains only ${args.names.joinToString(prefix = "[", postfix = "]")}")
    }

    override fun differentiate(varName: String, args: ExpressionArgs): Double =
        if (name == varName) 1.0 else 0.0

    override fun toString(): String {
        return name
    }
}

// todo implement f(g(x,y))
// todo rethink about variables and constants, may be they need separate logic?
// todo how to implement different return/input types?