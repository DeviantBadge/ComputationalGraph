package com.compute.graph.operation.interfaces.builders

import com.compute.graph.operation.base.BinaryOperation
import com.compute.graph.operation.base.IndependentOperand
import com.compute.graph.operation.base.IndependentOperation
import com.compute.graph.operation.base.MathExpression
import com.compute.graph.operation.base.TernaryOperation
import com.compute.graph.operation.base.TransformableExpression
import com.compute.graph.operation.base.UnaryOperation
import com.compute.graph.operation.base.VectorOperation
import com.compute.graph.util.SealedHelper
import com.compute.graph.util.extensions.logger
import org.joor.Reflect
import java.lang.IllegalArgumentException
import kotlin.reflect.KClass
import kotlin.reflect.full.isSubclassOf

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
