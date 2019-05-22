package com.compute.graph.operation.objects.constants

import kotlin.math.E

class ExpConstant : ScalarConstant(E) {
    companion object {
        val names = listOf("e", "exp")
    }

    override fun differentiate() {
        TODO("Function \"${javaClass.name}.differentiate\" not implemented")
    }

    override fun toString(): String {
        return "e"
    }
}
