package com.compute.graph.operation.props

data class OperationProperties(
        val canonicalName: String,
        val alternativeNames: List<String>,
        val communicative: Boolean,
        val associative: Boolean,
        val operationType: OperationType
)

enum class OperationType{
    INDEPENDENT,
    UNARY,
    BINARY,
    TERNARY,
    UNLIMITED
}