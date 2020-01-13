package com.compute.graph.util

import com.compute.graph.operations.objects.MathExpression
import com.compute.graph.operations.objects.Gradient
import com.compute.graph.operations.objects.MathObject
import com.compute.graph.operations.objects.Scalar
import com.compute.graph.operations.objects.Tensor
import com.compute.graph.util.extensions.rank
import java.lang.StringBuilder
import kotlin.reflect.jvm.jvmName

/**
 * @Author: evgeny
 * @Date: 27/12/2019
 */
object MathObjectPrinter {

    fun toPrettyString(mathObject: MathObject, printLevel: Int = 0, oneRowDimension: Int = 1): String =
        when (mathObject) {
            is Scalar -> toPrettyString(mathObject, printLevel, oneRowDimension)
            is Tensor -> toPrettyString(mathObject, printLevel, oneRowDimension)
            is Gradient -> toPrettyString(mathObject, printLevel, oneRowDimension)
            is MathExpression -> toPrettyString(mathObject, printLevel, oneRowDimension)
        }

    fun toPrettyString(scalar: Scalar, printLevel: Int = 0, oneRowDimension: Int = 1): String =
        tabulation(printLevel) + scalar

    fun toPrettyString(tensor: Tensor, printLevel: Int = 0, oneRowDimension: Int = 1): String {
        val separator: String = if (tensor.rank() <= oneRowDimension) ", " else ",\n"
        val postfix: String = if (tensor.rank() <= oneRowDimension) "]" else "\n" + tabulation(printLevel) + "]"
        return tensor.joinToString(
            separator = separator,
            prefix = tabulation(printLevel) + "[",
            postfix = postfix
        ) { toPrettyString(it, printLevel + 1, oneRowDimension) }
    }

    fun toPrettyString(gradient: Gradient, printLevel: Int = 0, oneRowDimension: Int = 1): String =
        gradient.asIterable()
            .joinToString(
                separator = ",\n",
                prefix = tabulation(printLevel) + "{",
                postfix = "\n" + tabulation(printLevel) + "}"
            ) {
                it.key + " : " + toPrettyString(it.value, printLevel + 1, oneRowDimension)
            }


    fun toPrettyString(expression: MathExpression, printLevel: Int = 0, oneRowDimension: Int = 1): String =
        TODO()

    private fun tabulation(printLevel: Int): String = " ".repeat(4 * (printLevel))
}