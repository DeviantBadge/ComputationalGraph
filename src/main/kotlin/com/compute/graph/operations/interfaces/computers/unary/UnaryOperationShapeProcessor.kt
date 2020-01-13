package com.compute.graph.operations.interfaces.computers.unary

import com.compute.graph.operations.objects.Gradient
import com.compute.graph.operations.objects.MathObject
import com.compute.graph.operations.objects.Scalar
import com.compute.graph.operations.objects.Tensor
import com.compute.graph.operations.objects.Shape
import kotlin.reflect.jvm.jvmName

/**
 * @Author: evgeny
 * @Date: 2019-07-22
 */
interface UnaryOperationShapeProcessor {
    fun computeShape(
        argVal: MathObject
    ): Shape =
        when (argVal) {
            is Gradient -> computeShape(argVal)
            is Tensor -> computeShape(argVal)
            is Scalar -> computeShape(argVal)
            else -> throw IllegalArgumentException("Unexpected argument type ${argVal::class.jvmName}")
        }

    fun computeShape(arg: Tensor): Shape

    fun computeShape(arg: Scalar): Shape

    fun computeShape(arg: Gradient): Shape
}