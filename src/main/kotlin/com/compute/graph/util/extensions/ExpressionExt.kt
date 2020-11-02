package com.compute.graph.util.extensions

import com.compute.graph.operations.builders.contexts.ArgsBuilder
import com.compute.graph.operations.interfaces.arguments.ComputationArgs
import com.compute.graph.operations.interfaces.core.binary.LEFT_ARGUMENT_PATTERN
import com.compute.graph.operations.interfaces.core.binary.RIGHT_ARGUMENT_PATTERN
import com.compute.graph.operations.interfaces.core.unary.UNARY_ARGUMENT_PATTERN
import com.compute.graph.operations.objects.BinaryOperation
import com.compute.graph.operations.objects.MathExpression
import com.compute.graph.operations.objects.MathObject
import com.compute.graph.operations.objects.UnaryOperation
import com.compute.graph.operations.visitors.execution.ComputationVisitor

fun UnaryOperation.compute(argumentValue: MathObject): MathObject =
    specification.computeResult(argumentValue)

fun UnaryOperation.derivative(argumentValue: MathObject): MathObject =
    specification.computeDerivative(argumentValue)

fun UnaryOperation.useStringPattern(argumentString: String): String =
    specification.toStringPattern.replace(UNARY_ARGUMENT_PATTERN, argumentString)


fun BinaryOperation.compute(leftArgumentValue: MathObject, rightArgumentValue: MathObject): MathObject =
    specification.computeResult(leftArgumentValue, rightArgumentValue)

fun BinaryOperation.leftArgDerivative(leftArgumentValue: MathObject, rightArgumentValue: MathObject): MathObject =
    specification.computeLeftArgDerivative(leftArgumentValue, rightArgumentValue)

fun BinaryOperation.rightArgDerivative(leftArgumentValue: MathObject, rightArgumentValue: MathObject): MathObject =
    specification.computeRightArgDerivative(leftArgumentValue, rightArgumentValue)

fun BinaryOperation.useStringPattern(leftArgumentString: String, rightArgumentString: String): String =
    specification.toStringPattern
        .replace(LEFT_ARGUMENT_PATTERN, leftArgumentString)
        .replace(RIGHT_ARGUMENT_PATTERN, rightArgumentString)


fun MathExpression.compute(computationArgs: ComputationArgs): MathObject =
    ComputationVisitor(this).compute(computationArgs)

fun MathExpression.compute(argsInit: ArgsBuilder.ArgsBuilderContext.() -> Unit): MathObject =
    ComputationVisitor(this).compute(ArgsBuilder.buildArgs(mutableMapOf(), argsInit))