package com.compute.graph.operations.objects.operands

import com.compute.graph.operations.objects.types.ScalarConstant
import kotlin.math.E

class ExpConstant : ScalarConstant(E) {
    override fun toString(): String {
        return "e"
    }
}
