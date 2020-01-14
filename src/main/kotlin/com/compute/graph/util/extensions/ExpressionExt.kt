package com.compute.graph.util.extensions

import com.compute.graph.operations.objects.BinaryOperation
import com.compute.graph.operations.objects.MathObject
import com.compute.graph.operations.objects.UnaryOperation

fun UnaryOperation.compute(argumentValue: MathObject): MathObject =
    computer.computeResult(argumentValue)

fun BinaryOperation.compute(leftArgumentValue: MathObject, rightArgumentValue: MathObject): MathObject =
    computer.computeResult(leftArgumentValue, rightArgumentValue)

fun UnaryOperation.derivative(argumentValue: MathObject): MathObject =
    computer.derivative(argumentValue)

fun BinaryOperation.leftArgDerivative(leftArgumentValue: MathObject, rightArgumentValue: MathObject): MathObject =
    computer.computeLeftArgDerivative(leftArgumentValue, rightArgumentValue)

fun BinaryOperation.rightArgDerivative(leftArgumentValue: MathObject, rightArgumentValue: MathObject): MathObject =
    computer.computeRightArgDerivative(leftArgumentValue, rightArgumentValue)