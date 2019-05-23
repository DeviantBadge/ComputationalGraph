package com.compute.graph.operation.objects.operators

import com.compute.graph.operation.annotations.ExpressionGraphPart
import com.compute.graph.operation.base.BinaryOperation
import com.compute.graph.operation.base.TransformableExpression
import io.github.classgraph.ClassGraph
import org.reflections.Reflections
import org.springframework.stereotype.Component
import kotlin.system.measureTimeMillis

/**
 * <p>Description:</P>
 * <p>Company:Alibaba</p>
 * @Author: evgeny.vorobyev
 * @Since: 1.0
 * @Version:1.0,Date:2019-05-21
 */
object OperatorBuilder {
}



fun main() {
//    println(FunctionBuilder::class.java.`package`.name)
    measureTimeMillis {
        val refl = Reflections()
        refl.getTypesAnnotatedWith(Component::class.java).forEach {
            println(it::class.java.name)
            println(it.kotlin.constructors.size)
        }
    }.also { println(it) }

    println()
    println(SumOp1::class.java.constructors.map { it.parameters.joinToString(postfix = "\n") }.joinToString())
    println()

    measureTimeMillis {
        ClassGraph().enableAllInfo()
                .whitelistPackages("")
                .scan()
                .use { scanResult ->
                    scanResult.allClasses
                            .filter { classInfo ->
                                classInfo.hasAnnotation(ExpressionGraphPart::class.java.canonicalName) &&
                                        classInfo.extendsSuperclass(TransformableExpression::class.java.canonicalName)
                            }.forEach {
                                println(it.name)
                            }
                }
    }.also { println(it) }
    // todo compare classgraph with reflections for speed/usage
}