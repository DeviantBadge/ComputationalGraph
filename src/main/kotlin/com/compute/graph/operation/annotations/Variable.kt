package com.compute.graph.operation.annotations

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@ExpressionGraphPart
annotation class Variable(
        val names: Array<String> = []
)