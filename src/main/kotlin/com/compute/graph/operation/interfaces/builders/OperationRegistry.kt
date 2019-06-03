package com.compute.graph.operation.interfaces.builders

import com.compute.graph.operation.base.MathExpression
import kotlin.reflect.KClass

/**
 * @Author: evgeny.vorobyev
 * @Since: 1.0
 * @Version: 1.0
 * @Date:2019-05-23
 */
interface OperationRegistry {

    val registeredNames: Set<String>

    fun isRegistered(name: String): Boolean =
        registeredNames.contains(name)

    fun register(
        names: List<String>,
        clazz: Class<out MathExpression>
    )

    fun register(
        vararg names: String,
        clazz: Class<out MathExpression>
    ) = register(names.toList(), clazz)

    fun register(
        names: List<String>,
        clazz: KClass<out MathExpression>
    ) = register(names, clazz.java)

    fun register(
        vararg names: String,
        clazz: KClass<out MathExpression>
    ) = register(names.toList(), clazz.java)
}
