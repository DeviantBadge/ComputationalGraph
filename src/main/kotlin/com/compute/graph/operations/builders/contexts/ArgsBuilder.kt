package com.compute.graph.operations.builders.contexts

/**
 * @Author: evgeny
 * @Date: 13/01/2020
 */
object ArgsBuilder {
    fun buildArgs(init: ArgsBuilderContext.() -> Unit) =
        ArgsBuilderContext().also { it.init() }.buildArgs()
}