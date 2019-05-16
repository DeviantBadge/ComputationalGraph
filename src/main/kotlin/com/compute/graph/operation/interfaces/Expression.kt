package com.compute.graph.operation.interfaces

import com.compute.graph.graph.DirectedGraph

interface Expression :
        DirectedGraph,
        Differentiable,
        Computable
/* todo, properties for transformation */ {

    override val parents: List<Expression>

    override val children: List<Expression>
}