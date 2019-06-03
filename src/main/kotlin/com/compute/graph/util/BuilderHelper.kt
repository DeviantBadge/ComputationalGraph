package com.compute.graph.util

import com.compute.graph.operation.base.BinaryOperation
import com.compute.graph.operation.base.MathExpression
import com.compute.graph.operation.base.properties.AssociationType
import com.compute.graph.operation.interfaces.builders.OperationBuilder

/**
 * @Author: evgeny.vorobyev
 * @Since: 1.0
 * @Version: 1.0
 * @Date: 2019-06-03
 */
object BuilderHelper {
    fun buildOperationChain(
        builder: OperationBuilder,
        name: String,
        operations: List<MathExpression>,
        associationType: AssociationType
    ): MathExpression? =
        if (operations.isEmpty())
            null
        else
            when (associationType) {
                AssociationType.LEFT -> {
                    var result = operations.first()
                    for (i in 1 until operations.size)
                        result = builder.buildBinaryOperation(name, result, operations[i])
                    result
                }
                AssociationType.RIGHT -> {
                    var result = operations.last()
                    for (i in operations.size - 2 downTo 0)
                        result = builder.buildBinaryOperation(name, result, operations[i])
                    result
                }
            }
}