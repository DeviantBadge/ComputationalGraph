package com.compute.graph.util.extensions

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
