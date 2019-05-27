package com.compute.graph.operation.objects.constants

import com.compute.graph.operation.annotations.Constant
import kotlin.math.E

@Constant("e", "exp")
class ExpConstant : ScalarConstant(E) {

    override fun toString(): String {
        return "e"
    }
}
