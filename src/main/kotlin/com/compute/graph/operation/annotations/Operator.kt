package com.compute.graph.operation.annotations

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@ExpressionGraphPart
annotation class Operator (
        val names: Array<String> = []
)