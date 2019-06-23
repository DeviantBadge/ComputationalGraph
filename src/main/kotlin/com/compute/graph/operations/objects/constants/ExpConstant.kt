package com.compute.graph.operations.objects.constants

import com.compute.graph.operations.annotations.Constant
import kotlin.math.E

@Constant("e", "exp")
class ExpConstant : ScalarConstant(E) {
    override fun toString(): String {
        return "e"
    }
}
