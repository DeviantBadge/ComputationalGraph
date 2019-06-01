package com.compute.graph.operation.objects.constants

import com.compute.graph.operation.base.ComputationResult
import com.compute.graph.operation.base.IndependentOperand
import com.compute.graph.operation.base.MultipleResult
import com.compute.graph.operation.base.ScalarComputationResult
import com.compute.graph.operation.interfaces.ExpressionArgs

abstract class ConstantValue(
    private val value: ComputationResult
) : IndependentOperand() {

    override fun compute(args: ExpressionArgs): ComputationResult {
        return value
    }

    override fun differentiateForward(args: ExpressionArgs): MultipleResult =
        MultipleResult(args.names.fold(hashMapOf()) { acc, name -> acc.also { it[name] = ScalarComputationResult(0.0) } })

    override fun differentiateBackward(args: ExpressionArgs): MultipleResult {
        TODO("Backward would be implemented after creation computation context")
    }

    override fun toString(): String {
        return value.toString()
    }
}