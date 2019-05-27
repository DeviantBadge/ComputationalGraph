/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Kotlin library project to get you started.
 */

plugins {
    // Apply the Kotlin JVM plugin to add support for Kotlin on the JVM.
    id("org.jetbrains.kotlin.jvm").version("1.3.31")
    java
    antlr
}

repositories {
    // Use jcenter for resolving your dependencies.
    // You can declare any Maven/Ivy/file repository here.
    jcenter()
    mavenCentral()
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_6
    targetCompatibility = JavaVersion.VERSION_1_6
}

dependencies {
    // Use the Kotlin JDK 8 standard library.
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    // coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.2.1")
    // kotlin reflection
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.3.31")
    // https://mvnrepository.com/artifact/cglib/cglib
    implementation("cglib:cglib:3.2.12")


    // https://mvnrepository.com/artifact/org.slf4j/slf4j-api
    implementation("org.slf4j:slf4j-api:1.7.26")
    // https://mvnrepository.com/artifact/org.slf4j/slf4j-simple
    implementation("org.slf4j:slf4j-simple:1.7.26")

    // https://mvnrepository.com/artifact/org.apache.commons/commons-math3
    implementation("org.apache.commons:commons-math3:3.6.1")


    // https://mvnrepository.com/artifact/org.springframework/spring-context
    implementation("org.springframework:spring-context:5.1.7.RELEASE")
    // scanners do not know what is better
    implementation("org.reflections:reflections:0.9.11")
    implementation("io.github.classgraph:classgraph:4.8.37")
    implementation("org.jooq:joor-java-8:0.9.7")


    // https://mvnrepository.com/artifact/org.antlr/antlr4-runtime
    implementation("org.antlr:antlr4-runtime:4.7.2")
    antlr("org.antlr:antlr4:4.7.2")

    // Use the Kotlin test library.
    testImplementation("org.jetbrains.kotlin:kotlin-test")

    // Use the Kotlin JUnit integration.
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
}
