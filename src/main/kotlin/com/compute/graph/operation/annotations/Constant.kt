package com.compute.graph.operation.annotations

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@ExpressionGraphPart
annotation class Constant  (
        val names: Array<String> = []
)