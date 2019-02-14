import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.10"
}

apply {
    plugin("application")
}

group = "com.aveys"
version = "1.0-SNAPSHOT"

configure<ApplicationPluginConvention> {
    mainClassName = "com.aveys.exope.MainKt"
    applicationName = "exope"
}

repositories {
    mavenCentral()
}

dependencies {
    compile(kotlin("stdlib-jdk8"))
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}