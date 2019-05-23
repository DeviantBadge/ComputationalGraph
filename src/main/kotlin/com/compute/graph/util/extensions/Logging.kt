package com.compute.graph.util.extensions

import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * @Author: evgeny.vorobyev
 * @Since: 1.0
 * @Version: 1.0
 * @Date:2019-05-23
 */
object Logging {
    val loggingBag: MutableMap<Class<*>, Logger> = hashMapOf()
}

inline fun <reified T : Any?> T.logger(): Logger {
    val clazz = if (T::class.isCompanion) T::class.java.enclosingClass
    else T::class.java
    return Logging.loggingBag[clazz]
            ?: LoggerFactory.getLogger(clazz).also {
                Logging.loggingBag[clazz] = it
            }
}
