package com.compute.graph.operations.base.util

import com.compute.graph.operations.interfaces.computers.unary.UnaryOperationProcessor
import com.compute.graph.operations.objects.*
import com.compute.graph.util.extensions.mapGradientValues

/**
 * @Author: evgeny
 * @Since: 1.0
 * @Version: 1.0
 * @Date: 2019-06-04
 */
abstract class UnaryOperationProcessorPattern :
    UnaryOperationProcessor {

    final override fun computeResult(argVal: MathObject): MathObject =
        super.computeResult(argVal)

    final override fun buildExpression(arg: MathExpression): MathExpression =
        UnaryOperation(arg, this)

    abstract override fun computeResult(arg: Scalar): MathObject

    override fun computeResult(arg: Tensor): MathObject =
        TODO("Computation 'for_all in tensor'")

    /**
     * Predefined function for Gradient
     */
    override fun computeResult(arg: Gradient): Gradient =
        arg.mapGradientValues { computeResult(it) }


    final override fun computeShape(argVal: MathObject): Shape =
        super.computeShape(argVal)

    override fun computeShape(arg: Tensor): Shape =
        arg.shape

    override fun computeShape(arg: Scalar): Shape =
        arg.shape

    override fun computeShape(arg: Gradient): Shape =
        arg.shape

    override fun computeShape(arg: MathExpression): Shape =
        arg.shape


    abstract override fun derivative(arg: MathObject): MathObject
}
