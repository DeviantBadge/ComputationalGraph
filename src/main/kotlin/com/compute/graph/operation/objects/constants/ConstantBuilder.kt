package com.compute.graph.operation.objects.constants

/**
 * <p>Description:</P>
 * <p>Company:Alibaba</p>
 * @Author: evgeny.vorobyev
 * @Since: 1.0
 * @Version:1.0,Date:2019-05-21
 */
object ConstantBuilder {
    fun build(value: String): ScalarConstant = when (value) {
        in ExpConstant.names -> ExpConstant()
        in PiConstant.names -> PiConstant()
        else -> {
            value.toDoubleOrNull()?.let { ScalarConstant(it) }
                    ?: throw IllegalArgumentException("Unexpected constant - $value, its not exponential, " +
                            "not pi constant, not double constant")
        }
    }
}