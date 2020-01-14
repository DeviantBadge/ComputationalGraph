package com.compute.graph.util.extensions

import com.compute.graph.operations.objects.Constant
import com.compute.graph.operations.objects.MathExpression
import com.compute.graph.operations.objects.MathObject
import com.compute.graph.operations.objects.Tensor

/**
 * @Author: evgeny
 * @Date: 2019-07-29
 */
//val Tensor.dimension: Int?
//    get() = shape?.firstOrNull()
//

fun Tensor.rank(): Int = shape.rank

fun Tensor.isVector(): Boolean = shape.rank == 1


fun MathObject.toMathExpression(): MathExpression =
    this as? MathExpression ?: Constant(this)