package com.compute.graph.operations.visitors.execution

import com.compute.graph.operations.objects.MathExpression
import com.compute.graph.operations.objects.MathObject

/**
 * @Author: evgeny
 * @Date: 13/01/2020
 */
class ComputedValues(
    private val computedValuesMap: MutableMap<MathExpression, MathObject>
) : MutableMap<MathExpression, MathObject> by computedValuesMap {
    constructor(computedValues: ComputedValues): this(computedValues.computedValuesMap)
    override operator fun get(key: MathExpression): MathObject = computedValuesMap[key] ?: key
}