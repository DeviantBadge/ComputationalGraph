package com.compute.graph.operations.annotations

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@ExpressionGraphPart
annotation class VariableDeclaration(
    vararg val names: String
)