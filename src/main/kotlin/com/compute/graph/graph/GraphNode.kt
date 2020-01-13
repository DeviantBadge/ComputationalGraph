package com.compute.graph.graph

/**
 * Basic tree node that we will use further
 */
interface GraphNode<T> {
    /**
     * Returns all children of current node
     */
    val parents: List<GraphNode<T>>

    /**
     * Return parents of current node
     */
    val children: List<GraphNode<T>>

    /**
     * Return value that stored in this node
     */
    val value: T
}
