package com.compute.graph.operations.builders

import com.compute.graph.operations.builders.contexts.ArgsBuilderContext
import com.compute.graph.operations.builders.contexts.ContextBuilderContext
import com.compute.graph.operations.interfaces.ExpressionArgs
import com.compute.graph.operations.interfaces.ExpressionContext

/**
 * @Author: evgeny
 * @Since: 1.0
 * @Version:1.0,Date:2019-05-21
 */
object ArgsBuilder {
    fun buildArgs(init: ArgsBuilderContext.() -> Unit): ExpressionArgs =
        ArgsBuilderContext().apply(init).buildArgs()

    fun buildContext(init: ContextBuilderContext.() -> Unit): ExpressionContext =
        ContextBuilderContext().apply(init).buildContext()
}