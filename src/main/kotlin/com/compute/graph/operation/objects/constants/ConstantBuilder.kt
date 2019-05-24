package com.compute.graph.operation.objects.constants

import com.compute.graph.operation.base.BinaryOperation
import com.compute.graph.operation.base.IndependentOperand
import com.compute.graph.operation.base.IndependentOperation
import com.compute.graph.operation.base.MathExpression
import com.compute.graph.operation.base.TernaryOperation
import com.compute.graph.operation.base.UnaryOperation
import com.compute.graph.operation.base.VectorOperation
import com.compute.graph.operation.base.builders.BaseBuilder
import javax.naming.OperationNotSupportedException

/**
 * <p>Description:</P>
 * <p>Company:Alibaba</p>
 * @Author: evgeny.vorobyev
 * @Since: 1.0
 * @Version:1.0,Date:2019-05-21
 */

object ConstantBuilder : BaseBuilder() {

    override fun buildIndependentOperation(
            name: String
    ): IndependentOperation {
        throw OperationNotSupportedException("Cant build operations in constants builder")
    }

    override fun buildIndependentOperand(
            name: String
    ): IndependentOperand {
        name.toDoubleOrNull()?.let {
            return ScalarConstant(it)
        }
        return super.buildIndependentOperand(name)
    }

    override fun buildUnaryOperation(
            name: String,
            argument: MathExpression
    ): UnaryOperation {
        throw OperationNotSupportedException("Cant build operations in constants builder")
    }

    override fun buildBinaryOperation(
            name: String,
            leftArgument: MathExpression,
            rightArgument: MathExpression
    ): BinaryOperation {
        throw OperationNotSupportedException("Cant build operations in constants builder")
    }

    override fun buildTernaryOperation(
            name: String,
            leftArgument: MathExpression,
            middleArgument: MathExpression,
            rightArgument: MathExpression
    ): TernaryOperation {
        throw OperationNotSupportedException("Cant build operations in constants builder")
    }

    override fun buildVectorOperation(
            name: String,
            vararg arguments: MathExpression
    ): VectorOperation {
        throw OperationNotSupportedException("Cant build operations in constants builder")
    }

    override fun buildVectorOperation(
            name: String,
            arguments: List<MathExpression>
    ): VectorOperation {
        throw OperationNotSupportedException("Cant build operations in constants builder")
    }
}
//
//open class a
//open class b: a()
//open class c: b()
//
//fun main() {
//    val class1: Class<out a> = c::class.java
//    val class2: Class<out a> = b::class.java
//    val class3: Class<out a> = a::class.java
//
//    println(class1.isAssignableFrom(class2))
//    println(class1.isAssignableFrom(class3))
//    println(class2.isAssignableFrom(class1))
//    println(class2.isAssignableFrom(class3))
//    println(class3.isAssignableFrom(class1))
//    println(class3.isAssignableFrom(class2))
//}