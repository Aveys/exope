import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.20"
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
    testImplementation("org.junit.jupiter:junit-jupiter:5.4.0")
}

tasks.withType<Jar> {
    baseName = "${rootProject.name}-fat"
    manifest {
        attributes["Implementation-Title"] = "exope"
        attributes["Implementation-Version"] = version
        attributes["Main-Class"] = "com.aveys.exope.MainKt"
    }
    from(configurations.runtime.map { if (it.isDirectory) it else zipTree(it) })
}

tasks.withType<Test> {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}