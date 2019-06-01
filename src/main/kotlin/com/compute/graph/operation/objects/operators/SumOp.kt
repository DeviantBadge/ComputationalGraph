package com.compute.graph.operation.objects.operators

import com.compute.graph.operation.annotations.Operator
import com.compute.graph.operation.base.*
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
    override fun compute(args: ExpressionArgs): ComputationResult =
        when (val leftChildResult = leftArgument.compute(args)) {
            is ScalarComputationResult ->
                when (val rightChildResult = leftArgument.compute(args)) {
                    is ScalarComputationResult ->
                        ScalarComputationResult(leftChildResult.value / rightChildResult.value)
                    is VectorComputationResult -> TODO()
                    is MatrixComputationResult -> TODO()
                    is MultipleResult -> TODO()
                }
            is VectorComputationResult -> TODO()
            is MatrixComputationResult -> TODO()
            is MultipleResult -> TODO()
        }

    override fun differentiateForward(args: ExpressionArgs): MultipleResult {
        TODO("Function \"${javaClass.name}.differentiateForward\" not implemented")
    }

    override fun differentiateBackward(args: ExpressionArgs): MultipleResult {
        TODO("Function \"${javaClass.name}.differentiateBackward\" not implemented")
    }
}

// todo create ComputationalContext
// todo create both differential methods
// todo for backward alg we put result in map and accumulate result in map
