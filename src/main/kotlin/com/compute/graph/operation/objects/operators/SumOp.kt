package com.compute.graph.operation.objects.operators

import com.compute.graph.operation.annotations.Operator
import com.compute.graph.operation.base.MathExpression
import com.compute.graph.operation.base.VectorOperation
import com.compute.graph.operation.interfaces.ExpressionArgs
import com.compute.graph.operation.objects.arguments.ScalarArguments
import com.sun.org.apache.xpath.internal.operations.Div
import org.joor.Reflect
import org.reflections.Reflections
import java.lang.Exception
import kotlin.reflect.KTypeProjection
import kotlin.reflect.KVariance
import kotlin.reflect.full.*
import kotlin.reflect.jvm.javaType
import kotlin.reflect.jvm.jvmErasure
import kotlin.system.measureNanoTime
import kotlin.system.measureTimeMillis

@Operator("+")
class SumOp(
        arguments: MutableList<MathExpression>
) : VectorOperation(arguments) {
    constructor(vararg arguments: MathExpression) : this(arguments.toMutableList())

    override fun compute(args: ExpressionArgs): Double {
        return children.fold(0.0) { sum, element -> sum + element.compute(args) }
    }

    override fun differentiate(varName: String, args: ExpressionArgs): Double =
            arguments.fold(0.0) { acc, expr ->
                acc + expr.differentiate(varName, args)
            }
}

// todo create ComputationalContext
// todo create both differential methods
// todo for backward alg we put result in map and accumulate result in map
