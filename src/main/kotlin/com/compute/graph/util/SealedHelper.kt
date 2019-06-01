package com.compute.graph.util

import com.compute.graph.util.extensions.isSuperclassOf
import kotlin.reflect.KClass
import kotlin.reflect.full.isSuperclassOf

class SealedHelper<T : Any>(
    kClass: KClass<T>
) {
    private val sealedTypes: List<KClass<out T>> = kClass.sealedSubclasses

    private val sealedKotlinNumbers: MutableMap<KClass<out T>, Int> = sealedTypes.withIndex().associateTo(hashMapOf()) { it.value to it.index }

    private val sealedJavaNumbers: MutableMap<Class<out T>, Int> =
        sealedTypes.map { it.java }
            .withIndex()
            .associateTo(hashMapOf()) { it.value to it.index }

    fun getSealedNumber(kClass: KClass<out T>): Int =
        sealedKotlinNumbers[kClass]
            ?: sealedTypes.indexOfFirst { it.isSuperclassOf(kClass) }
                .also { sealedKotlinNumbers[kClass] = it }

    fun getSealedNumber(clazz: Class<out T>): Int =
        sealedJavaNumbers[clazz]
            ?: sealedTypes.indexOfFirst { it.isSuperclassOf(clazz) }
                .also { sealedJavaNumbers[clazz] = it }

    val sealedTypesAmount = sealedTypes.size
}