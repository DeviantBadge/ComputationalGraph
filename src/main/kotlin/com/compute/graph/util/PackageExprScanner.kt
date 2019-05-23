package com.compute.graph.util

import io.github.classgraph.ClassInfoList

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
    ) {

    }

    fun scanPackages(packages: List<Package>) =
            scanPackages(packages.map { it.name })
}