package com.compute.graph.operations.interfaces.computers.unary

import com.compute.graph.operations.objects.MathObject

/**
 * @Author: evgeny
 * @Date: 2019-07-22
 */
interface UnaryOperationDerivativeProcessor {
    fun derivative(arg: MathObject): MathObject
}