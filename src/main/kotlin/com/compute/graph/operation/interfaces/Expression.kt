package com.compute.graph.operation.interfaces

import com.compute.graph.graph.DirectedGraph

// todo не городи сущностей без надобности
// todo необходимо отрефакторить код так, что бы можно было удалить все ненужные сущности
interface Expression :
    DirectedGraph,
    Differentiable,
    Computable
/* todo, properties for transformation */ {

    override val parents: List<Expression>

    override val children: List<Expression>
}