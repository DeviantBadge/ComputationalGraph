package com.compute.graph.util.extensions

import com.compute.graph.operations.objects.*

/**
 * @Author: evgeny
 * @Date: 2019-07-29
 */
//val Tensor.dimension: Int?
//    get() = shape?.firstOrNull()
//
fun AlgebraicShape.rank(): Int = when(this) {
        is ScalarShape -> 0
        is TensorShape -> this.shape.size
    }
