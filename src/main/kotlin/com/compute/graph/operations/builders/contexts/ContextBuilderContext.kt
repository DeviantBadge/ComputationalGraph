package com.compute.graph.operations.builders.contexts

import com.compute.graph.operations.interfaces.ExpressionContext
import com.compute.graph.operations.objects.arguments.ComputationContext

/**
 * @Author: evgeny
 * @Date: 2019-06-23
 */
class ContextBuilderContext : ArgsBuilderContext() {

    fun buildContext(): ExpressionContext =
        ComputationContext(values)
}