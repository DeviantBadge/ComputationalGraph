package com.compute.graph.operation.objects.variables

import com.compute.graph.operation.base.IndependentOperation
import com.compute.graph.operation.base.TransformableExpression
import com.compute.graph.operation.interfaces.ExpressionArgs
import java.lang.IllegalArgumentException

class ScalarVariable(
        private val name: String
) : IndependentOperation() {

    override fun compute(args: ExpressionArgs): Double {
        return args[name] ?: throw IllegalArgumentException("Arguments do not contain variable with name $name. " +
                "It contains only ${args.names.joinToString (prefix = "[", postfix = "]")}")
    }

    override fun differentiate() {
        TODO("Function \"${javaClass.name}.differentiate\" not implemented")
    }

    override fun toString(): String {
        return name
    }
}