import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    Libs.plugins.forEach { (id, version) ->
        id(id) version version
    }
}

group = "io.github.leeseojune53"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    Libs.implementations.forEach(::implementation)
    Libs.compileOnly.forEach(::compileOnly)
    Libs.annotationProcessor.forEach(::annotationProcessor)
    Libs.testImplementation.forEach(::testImplementation)
}

spotless {
    kotlin {
        ktlint()
        trimTrailingWhitespace()
    }
    kotlinGradle {
        ktlint()
        trimTrailingWhitespace()
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
