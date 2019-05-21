package com.compute.graph.operation.interfaces

interface PropertyHolder {
    val name: String
    val alternativeNames: List<String>
    val communicative: Boolean
    val associative: Boolean
}