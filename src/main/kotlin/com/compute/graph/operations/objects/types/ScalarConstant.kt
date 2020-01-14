package com.compute.graph.operations.objects.types

import com.compute.graph.operations.objects.Scalar
import com.compute.graph.operations.objects.ScalarShape

/**
 * This type represents scalars (tensor rank = 0)
 */
open class ScalarConstant(
    value: Number
) : Scalar() {
    override val value: Double = value.toDouble()
    override val shape = ScalarShape
}