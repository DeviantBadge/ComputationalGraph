package com.compute.graph.operations.interfaces.core.unary

import com.compute.graph.operations.objects.MathObject

/**
 * @Author: evgeny
 * @Date: 2019-07-22
 */
interface UnaryOperationDerivativeProcessor {
    fun computeDerivative(arg: MathObject): MathObject
}