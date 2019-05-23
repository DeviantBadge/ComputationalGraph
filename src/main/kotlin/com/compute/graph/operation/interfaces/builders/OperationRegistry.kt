package com.compute.graph.operation.interfaces.builders

import com.compute.graph.operation.base.TransformableExpression
import com.compute.graph.util.extensions.logger

/**
 * @Author: evgeny.vorobyev
 * @Since: 1.0
 * @Version: 1.0
 * @Date:2019-05-23
 */
interface OperationRegistry {
    val registered: MutableMap<String, Class<out TransformableExpression>>

    fun register(
            names: List<String>,
            clazz: Class<out TransformableExpression>
    ) =
            names.forEach { name ->
                val hidden = registered.put(name, clazz)
                        ?: return@register
                logger().warn("New object '${clazz.name}' hides previous one '${hidden.name}' for name '$name'")
            }

    fun register(
            names: Array<String>,
            clazz: Class<out TransformableExpression>
    ) =
            register(names.toList(), clazz)
}