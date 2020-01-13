package com.compute.graph.util.extensions

import com.compute.graph.operations.objects.MathExpression
import com.compute.graph.operations.objects.Gradient
import com.compute.graph.operations.objects.MathObject
import com.compute.graph.operations.objects.types.GradientImpl

/**
 * @Author: evgeny
 * @Date: 2019-08-03
 */
fun Map<String, MathObject>.toGradient(): Gradient =
    GradientImpl(this.toMutableMap())

inline fun Gradient.mapGradientValues(transform: (MathObject) -> MathObject): Gradient =
    this.mapValues {(_, value) -> transform(value) }
        .toGradient()

inline fun Gradient.mapGradientValuesWith(second: Gradient, transform: (MathObject, MathObject) -> MathObject): Gradient =
    this.keys
        .union(second.keys)
        .associateWith { key -> transform(this[key], second[key]) }
        .toGradient()
