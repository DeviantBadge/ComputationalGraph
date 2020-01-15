package com.compute.graph.operations.base.util

import com.compute.graph.operations.interfaces.core.unary.UnaryOperationCore
import com.compute.graph.operations.objects.*
import com.compute.graph.util.extensions.mapGradientValues

/**
 * @Author: evgeny
 * @Since: 1.0
 * @Version: 1.0
 * @Date: 2019-06-04
 */
abstract class UnaryOperationCorePattern :
    UnaryOperationCore {

    final override fun computeResult(arg: MathObject): MathObject =
        super.computeResult(arg)

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


    final override fun computeShape(arg: Shape): Shape =
        super.computeShape(arg)

    override fun computeShape(arg: TensorShape): Shape =
        arg

    override fun computeShape(arg: ScalarShape): Shape =
        arg

    override fun computeShape(arg: GradientShape): Shape =
        arg

    override fun computeShape(arg: MathExpressionShape): Shape =
        arg


    abstract override fun computeDerivative(arg: MathObject): MathObject
}
