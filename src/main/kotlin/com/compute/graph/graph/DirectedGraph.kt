package com.compute.graph.graph

interface DirectedGraph {
    /**
     * Returns all children of current node
     */
    val parents: List<DirectedGraph>

    /**
     * Return parents of current node
     */
    val children: List<DirectedGraph>
}