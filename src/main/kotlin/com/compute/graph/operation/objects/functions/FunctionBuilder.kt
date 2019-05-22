package com.compute.graph.operation.objects.functions

import com.compute.graph.operation.base.BinaryOperation
import com.compute.graph.operation.base.TransformableExpression
import com.compute.graph.operation.objects.constants.ExpConstant
import com.compute.graph.operation.objects.constants.PiConstant
import com.compute.graph.operation.objects.constants.ScalarConstant
import com.compute.graph.operation.objects.operators.DivOp
import io.github.classgraph.ClassGraph
import org.reflections.Reflections
import org.springframework.stereotype.Component
import org.springframework.util.ClassUtils.hasMethod
import org.springframework.core.annotation.AnnotatedElementUtils.hasAnnotation
import kotlin.reflect.KFunction
import kotlin.reflect.KVisibility


/**
 * <p>Description:</P>
 * <p>Company:Alibaba</p>
 * @Author: evgeny.vorobyev
 * @Since: 1.0
 * @Version:1.0,Date:2019-05-21
 */
object FunctionBuilder {
    fun build(value: String): ScalarConstant = when (value) {
//        ExpConstant.names -> ExpConstant()
        in PiConstant.names -> PiConstant()
        else -> {
            value.toDoubleOrNull()?.let { ScalarConstant(it) }
                    ?: throw IllegalArgumentException("Unexpected constant - $value, its not exponential, " +
                            "not pi constant, not double constant")
        }
    }
}

fun main() {
//    println(FunctionBuilder::class.java.`package`.name)
    val refl = Reflections()
    refl.getTypesAnnotatedWith(Component::class.java).forEach {
        println(TransformableExpression::class.java.isAssignableFrom(it))
        println(it.kotlin.constructors.size)
    }

    println()
    println(DivOp::class.constructors.map { it.parameters[0].equals() == BinaryOperation::class.constructors.first().parameters }.joinToString())
    println()

    // todo compare classgraph with reflections for speed/usage
    ClassGraph().enableAllInfo()
            .whitelistPackages("")
            .scan()
            .use { scanResult ->
                scanResult.allClasses
                        .filter { classInfo ->
                            classInfo.hasAnnotation(Component::class.java.canonicalName)
                        }.forEach {
                            println(it.name)
                        }
            }
}