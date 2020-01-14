package com.compute.graph.operations.objects.types

import com.compute.graph.operations.objects.Gradient
import com.compute.graph.operations.objects.MathObject
import com.compute.graph.operations.objects.Shape

/**
 * @Author: evgeny
 * @Date: 2019-07-29
 */
class GradientImpl(
    private val differentials: MutableMap<String, MathObject>
) : Gradient(), Map<String, MathObject> by differentials {
    constructor(vararg pairs: Pair<String, MathObject>): this(mutableMapOf(*pairs))

    override val shape: Shape
        get() = TODO("Property \"${javaClass.name}.shape\" not implemented")
    override fun set(key: String, value: MathObject): MathObject? =
        differentials.put(key, value)


    override fun get(key: String): MathObject =
        differentials[key] ?: ScalarConstant(0)
}

