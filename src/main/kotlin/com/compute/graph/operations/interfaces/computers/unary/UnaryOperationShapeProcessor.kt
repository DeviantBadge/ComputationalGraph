package com.compute.graph.operations.interfaces.computers.unary

import com.compute.graph.operations.objects.*
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
            is MathExpression -> computeShape(argVal)
        }

    fun computeShape(arg: Tensor): Shape

    fun computeShape(arg: Scalar): Shape

    fun computeShape(arg: Gradient): Shape

    fun computeShape(arg: MathExpression): Shape
}