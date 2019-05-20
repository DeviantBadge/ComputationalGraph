package com.compute.graph.operation.objects.variables

import com.compute.graph.operation.base.TransformableExpression
import com.compute.graph.operation.interfaces.ExpressionArgs
import java.lang.IllegalArgumentException

class ScalarVariable(private val name: String) : TransformableExpression() {

    override val mutableParents: MutableList<TransformableExpression> = mutableListOf()
    override val mutableChildren: MutableList<TransformableExpression> = mutableListOf()

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