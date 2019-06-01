package com.compute.graph.util.extensions

import kotlin.reflect.KClass

fun KClass<*>.isSubclassOf(clazz: Class<*>): Boolean =
    clazz.isAssignableFrom(this.java)

fun Class<*>.isSubclassOf(clazz: Class<*>): Boolean =
    clazz.isAssignableFrom(this)

fun Class<*>.isSubclassOf(clazz: KClass<*>): Boolean =
    clazz.java.isAssignableFrom(this)

fun KClass<*>.isSuperclassOf(clazz: Class<*>): Boolean =
    this.java.isAssignableFrom(clazz)

fun Class<*>.isSuperclassOf(clazz: Class<*>): Boolean =
    this.isAssignableFrom(clazz)

fun Class<*>.isSuperclassOf(clazz: KClass<*>): Boolean =
    this.isAssignableFrom(clazz.java)
