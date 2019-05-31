package com.compute.graph.operation.objects.constants

import com.compute.graph.operation.annotations.Constant
import kotlin.math.PI

@Constant("pi", "Pi")
class PiConstant : ScalarConstant(PI) {
    override fun toString(): String {
        return "π"
    }
}