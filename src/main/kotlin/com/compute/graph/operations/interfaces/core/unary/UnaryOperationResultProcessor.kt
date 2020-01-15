package com.compute.graph.operations.interfaces.core.unary

import com.compute.graph.operations.objects.MathExpression
import com.compute.graph.operations.objects.Gradient
import com.compute.graph.operations.objects.MathObject
import com.compute.graph.operations.objects.Scalar
import com.compute.graph.operations.objects.Tensor
import kotlin.reflect.jvm.jvmName

/**
 * @Author: evgeny
 * @Date: 2019-07-22
 */
interface UnaryOperationResultProcessor {
    fun computeResult(
        arg: MathObject
    ): MathObject =
        if (arg is MathExpression) {
            buildExpression(arg)
        } else {
            when (arg) {
                is Gradient -> computeResult(arg)
                is Tensor -> computeResult(arg)
                is Scalar -> computeResult(arg)
                else -> throw IllegalArgumentException("Unexpected argument type ${arg::class.jvmName}")
            }
        }


    fun buildExpression(arg: MathExpression): MathExpression

    fun computeResult(arg: Tensor): MathObject

    fun computeResult(arg: Scalar): MathObject

    fun computeResult(arg: Gradient): Gradient
}