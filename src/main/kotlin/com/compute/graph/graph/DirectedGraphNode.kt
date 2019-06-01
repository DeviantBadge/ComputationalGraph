package com.compute.graph.graph

/**
 * Basic tree node that we will use further
 */
interface DirectedGraphNode<T> : DirectedGraph {
    /**
     * Returns all children of current node
     */
    override val parents: List<DirectedGraphNode<T>>

    /**
     * Return parents of current node
     */
    override val children: List<DirectedGraphNode<T>>

    /**
     * Return value that stored in this node
     */
    val value: T
}
