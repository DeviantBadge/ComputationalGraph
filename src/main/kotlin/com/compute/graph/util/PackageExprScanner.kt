package com.compute.graph.util

import com.sun.deploy.util.ArrayUtil
import com.sun.tools.javac.util.ArrayUtils
import io.github.classgraph.ClassGraph
import io.github.classgraph.ClassInfo
import io.github.classgraph.ClassInfoList
import io.github.classgraph.ScanResult
import java.lang.Exception
import java.util.*

/**
 * @Author: evgeny.vorobyev
 * @Since: 1.0
 * @Version:1.0,Date:2019-05-23
 */
object PackageExprScanner {

    fun scanPackages(
            packages: List<String> = listOf(""),
            annotations: List<String> = listOf(),
            implementedInterfaces: List<String> = listOf(),
            extendsClasses: List<String> = listOf()
    ): ClassInfoList {
        ClassGraph()
                    .verbose()
                    .enableAllInfo()
                    .whitelistPackages(*packages.toTypedArray())
                    .scan()
                .use {
                    return it.allClasses.filter{classInfo ->
                        annotations.all {annotationName -> classInfo.hasAnnotation(annotationName) }
                                && implementedInterfaces.all { interfaceName -> classInfo.implementsInterface(interfaceName) }
                                && extendsClasses.all { interfaceName -> classInfo.implementsInterface(interfaceName) }
                    }
                }
    }

    fun scanPackages(packages: List<Package>) =
            scanPackages(packages.map { it.name })
}