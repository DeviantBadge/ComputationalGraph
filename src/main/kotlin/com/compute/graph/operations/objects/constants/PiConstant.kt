package com.compute.graph.operations.objects.constants

import com.compute.graph.operations.annotations.Constant
import kotlin.math.PI

@Constant("pi", "Pi")
class PiConstant : ScalarConstant(PI) {
    override fun toString(): String {
        return "π"
    }
}