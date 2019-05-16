package com.compute.graph.operation.interfaces

import com.compute.graph.operation.base.OperationType

interface PropertyHolder {
    val name: String
    val alternativeNames: List<String>
    val communicative: Boolean
    val associative: Boolean
    val operationType: OperationType
}