package com.compute.graph.util

import com.compute.graph.operations.objects.*
import com.compute.graph.operations.objects.operands.ExpConstant
import com.compute.graph.operations.objects.operands.PiConstant
import com.compute.graph.util.extensions.rank
import com.compute.graph.util.extensions.useStringPattern

/**
 * @Author: evgeny
 * @Date: 27/12/2019
 */
object MathObjectPrinter {

    fun toPrettyString(
        mathObject: MathObject,
        printLevel: Int = 0,
        oneRowDimension: Int = 1,
        fromNewLine: Boolean = true
    ): String =
        when (mathObject) {
            is Scalar -> toPrettyString(mathObject, printLevel, oneRowDimension, fromNewLine)
            is Tensor -> toPrettyString(mathObject, printLevel, oneRowDimension, fromNewLine)
            is Gradient -> toPrettyString(mathObject, printLevel, oneRowDimension, fromNewLine)
            is MathExpression -> toPrettyString(mathObject, printLevel, oneRowDimension, fromNewLine)
        }

    private fun toPrettyString(
        scalar: Scalar,
        printLevel: Int = 0,
        oneRowDimension: Int = 1,
        fromNewLine: Boolean = true
    ): String =
        if (fromNewLine) tabulation(printLevel) else "" +
            when (scalar) {
                is ExpConstant -> "e"
                is PiConstant -> "π"
                else -> scalar.value.toString()
            }

    private fun toPrettyString(
        tensor: Tensor,
        printLevel: Int = 0,
        oneRowDimension: Int = 1,
        fromNewLine: Boolean = true
    ): String {
        val prefix: String = if (fromNewLine) tabulation(printLevel) + "[" else "["
        val postfix: String = if (tensor.rank() <= oneRowDimension) "]" else "\n" + tabulation(printLevel) + "]"
        return tensor.joinToString(
            separator = ", ",
            prefix = prefix,
            postfix = postfix
        ) { toPrettyString(it, printLevel + 1, oneRowDimension, tensor.rank() == oneRowDimension + 1) }
    }

    private fun toPrettyString(
        gradient: Gradient,
        printLevel: Int = 0,
        oneRowDimension: Int = 1,
        fromNewLine: Boolean = true
    ): String =
        gradient.asIterable()
            .joinToString(
                prefix = (if (fromNewLine) tabulation(printLevel) else "") + "{\n" + tabulation(printLevel + 1),
                separator = ",\n" + tabulation(printLevel + 1),
                postfix = "\n" + tabulation(printLevel) + "}"
            ) {
                it.key + " : " + toPrettyString(it.value, printLevel + 1, oneRowDimension, false)
            }

    private fun toPrettyString(
        expression: MathExpression,
        printLevel: Int = 0,
        oneRowDimension: Int = 1,
        fromNewLine: Boolean = true
    ): String =
        (if (fromNewLine) tabulation(printLevel) else "") + when (expression) {
            is Variable -> expression.name
            is Constant -> toPrettyString(expression.value, printLevel, oneRowDimension, fromNewLine)
            is UnaryOperation -> {
                val argumentSubString = toPrettyString(expression.argument, printLevel, oneRowDimension, false)
                expression.useStringPattern(argumentSubString)
            }
            is BinaryOperation -> {
                val leftArgString = toPrettyString(expression.leftArgument, printLevel, oneRowDimension, false)
                val rightArgString = toPrettyString(expression.rightArgument, printLevel, oneRowDimension, false)
                expression.useStringPattern(leftArgString, rightArgString)
            }
        }



    private fun tabulation(printLevel: Int): String = " ".repeat(4 * (printLevel))
}