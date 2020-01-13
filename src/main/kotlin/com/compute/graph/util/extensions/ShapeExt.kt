package com.compute.graph.util.extensions

import com.compute.graph.operations.objects.TensorShape
import com.compute.graph.operations.objects.TensorShapeBuilder

/**
 * @Author: evgeny
 * @Date: 2019-07-29
 */
//val Tensor.dimension: Int?
//    get() = shape?.firstOrNull()
//
val TensorShape.rank: Int
    get() = shape.size
