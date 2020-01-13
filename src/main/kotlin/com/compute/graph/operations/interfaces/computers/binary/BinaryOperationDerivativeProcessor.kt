package com.compute.graph.operations.interfaces.computers.binary

import com.compute.graph.operations.objects.MathObject

/**
 * @Author: evgeny
 * @Date: 2019-07-22
 */
interface BinaryOperationDerivativeProcessor {
    /**
     * Derivatives values, related to left and right arguments:
     * (f(x, y))' = f'x(x, y) * dx + f'y(x, y) * dy
     * f'x(x, y) - left arg derivative
     */
    fun computeLeftArgDerivative(leftArg: MathObject, rightArg: MathObject): MathObject


    /**
     * Derivatives values, related to left and right arguments:
     * (f(x, y))' = f'x(x, y) * dx + f'y(x, y) * dy
     * f'y(x, y) - right arg derivative (when x and y are specified)
     */
    fun computeRightArgDerivative(leftArg: MathObject, rightArg: MathObject): MathObject
}