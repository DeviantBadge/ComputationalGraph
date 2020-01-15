package com.compute.graph.util.extensions

import com.compute.graph.operations.interfaces.core.binary.BinaryOperationResultProcessor
import com.compute.graph.operations.objects.MathObject
import com.compute.graph.operations.objects.types.ScalarConstant

/**
 * @Author: evgeny
 * @Date: 2019-07-30
 */
fun BinaryOperationResultProcessor.compute(
    leftArg: Number,
    rightArg: MathObject
): MathObject =
    computeResult(ScalarConstant(leftArg), rightArg)

fun BinaryOperationResultProcessor.compute(
    leftArg: MathObject,
    rightArg: Number
): MathObject =
    computeResult(leftArg, ScalarConstant(rightArg))

fun BinaryOperationResultProcessor.compute(
    leftArg: Number,
    rightArg: Number
): MathObject =
    computeResult(ScalarConstant(leftArg), ScalarConstant(rightArg))
