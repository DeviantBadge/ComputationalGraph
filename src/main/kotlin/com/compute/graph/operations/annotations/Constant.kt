package com.compute.graph.operations.annotations

// todo i do not really like such annotations
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@ExpressionGraphPart
annotation class Constant(
    vararg val names: String
)