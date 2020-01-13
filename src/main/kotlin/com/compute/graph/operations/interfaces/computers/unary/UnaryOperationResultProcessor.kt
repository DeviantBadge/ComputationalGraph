package com.compute.graph.operations.interfaces.computers.unary

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
        argVal: MathObject
    ): MathObject =
        if (argVal is MathExpression) {
            buildExpression(argVal)
        } else {
            when (argVal) {
                is Gradient -> computeResult(argVal)
                is Tensor -> computeResult(argVal)
                is Scalar -> computeResult(argVal)
                else -> throw IllegalArgumentException("Unexpected argument type ${argVal::class.jvmName}")
            }
        }


    fun buildExpression(arg: MathExpression): MathExpression

    fun computeResult(arg: Tensor): MathObject

    fun computeResult(arg: Scalar): MathObject

    fun computeResult(arg: Gradient): Gradient
}