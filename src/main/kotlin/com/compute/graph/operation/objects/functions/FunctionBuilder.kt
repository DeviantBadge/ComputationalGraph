package com.compute.graph.operation.objects.functions

import com.compute.graph.operation.objects.constants.ExpConstant
import com.compute.graph.operation.objects.constants.PiConstant
import com.compute.graph.operation.objects.constants.ScalarConstant

/**
 * <p>Description:</P>
 * <p>Company:Alibaba</p>
 * @Author: evgeny.vorobyev
 * @Since: 1.0
 * @Version:1.0,Date:2019-05-21
 */
object FunctionBuilder {
    fun build(value: String): ScalarConstant = when (value) {
        ExpConstant.names -> ExpConstant()
        in PiConstant.names -> PiConstant()
        else -> {
            value.toDoubleOrNull()?.let { ScalarConstant(it) }
                    ?: throw IllegalArgumentException("Unexpected constant - $value, its not exponential, " +
                            "not pi constant, not double constant")
        }
    }
}