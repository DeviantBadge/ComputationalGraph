package com.compute.graph.operations.builders

import com.compute.graph.operations.objects.MathExpression
import com.compute.graph.operations.builders.interfaces.OperationBuilder
import com.compute.graph.operations.builders.interfaces.OperationRegistry
import com.compute.graph.util.SealedHelper
import org.joor.Reflect
import org.joor.ReflectException
import java.lang.IllegalArgumentException
import kotlin.reflect.KClass

abstract class BaseBuilder : OperationBuilder, OperationRegistry {
    private val sealedHelper = SealedHelper(MathExpression::class)

    //************************************************************************************************************//
    //                                      Registry part
    //------------------------------------------------------------------------------------------------------------//
    // At this part we implement OperationRegistry methods, such as registered expressions, register expression
    // and registered names
    //************************************************************************************************************//
    protected val registeredExpressions =
        List(sealedHelper.sealedTypesAmount) {
            hashMapOf<String, Class<out MathExpression>>()
        }

    override val registeredNames: Set<String>
        get() = registeredExpressions
            .map { it.keys }
            .fold(hashSetOf()) { acc, elem ->
                acc.apply { addAll(elem) }
            }

    fun registeredNames(sealedNumber: Int): Set<String> =
        registeredExpressions[sealedNumber].keys

    override fun register(names: List<String>, clazz: Class<out MathExpression>) {
        val exprNumber = sealedHelper.getSealedNumber(clazz)
        names.forEach { name ->
            registeredExpressions[exprNumber].put(name, clazz)?.also {
                print("New object '${clazz.name}' hides previous one '${it.name}' for name '$name'")
            }
        }
    }

    //************************************************************************************************************//
    //                                      Builder part
    //------------------------------------------------------------------------------------------------------------//
    // At this part we implement OperationBuilder methods
    //************************************************************************************************************//
    override fun <T : MathExpression> build(
        exprType: KClass<T>,
        name: String,
        vararg arguments: Any
    ): T {
        val exprNumber = sealedHelper.getSealedNumber(exprType)
        registeredExpressions[exprNumber][name]?.let {
            try {
                return Reflect.on(it).create(*arguments).get()
            } catch (exc: ReflectException) {
                throw UnsupportedOperationException("Failed to call constructor on class '${it.canonicalName}', error message - '${exc.message}'", exc)
            }
        }

        throw IllegalArgumentException("We do not have operation with name $name for operation type ${exprType.simpleName}, " +
            "currently registered operands - " + registeredNames(exprNumber).joinToString(prefix = "[", postfix = "]"))
    }


}