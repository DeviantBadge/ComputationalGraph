package com.compute.graph.operation.interfaces

import com.compute.graph.graph.DirectedGraph
import com.compute.graph.operation.props.OperationProperties

// todo преобразующийся граф
interface Expression : DirectedGraph, Differentiable, Computable {
    override val parents: List<Expression>

    override val children: List<Expression>

    val properties: OperationProperties
}