package com.compute.graph.operation.objects.constants

import com.compute.graph.operation.base.ComputationResult
import com.compute.graph.operation.base.IndependentOperand
import com.compute.graph.operation.base.MultipleResult
import com.compute.graph.operation.base.ScalarComputationResult
import com.compute.graph.operation.interfaces.ExpressionArgs
import com.compute.graph.operation.interfaces.ExpressionContext

abstract class ConstantValue(
    private val value: ComputationResult
) : IndependentOperand() {

    override fun computeResult(
        context: ExpressionContext
    ): ComputationResult = value

    // todo symplify
    override fun differentiateForward(args: ExpressionArgs): MultipleResult =
        MultipleResult(args.names.fold(hashMapOf()) { acc, name -> acc.also { it[name] = ScalarComputationResult(0.0) } })

    override fun differentiateBackward(args: ExpressionArgs): MultipleResult {
        TODO("Backward would be implemented after creation computation context")
    }

    override fun toString(): String =
        value.toString()
}