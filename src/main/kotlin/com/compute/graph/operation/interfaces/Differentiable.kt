package com.compute.graph.operation.interfaces

interface Differentiable {
    fun differentiate(varName: String, args: ExpressionArgs): Double // todo
}