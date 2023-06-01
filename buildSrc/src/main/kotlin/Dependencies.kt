object PluginVersions {
    const val springFramework = "3.1.0"
    const val springDependencyManagement = "1.1.0"
    const val kotlin = "1.8.21"
}

object Libs {

    val plugins = listOf(
        "org.springframework.boot" to PluginVersions.springFramework,
        "io.spring.dependency-management" to PluginVersions.springDependencyManagement,
        "org.jetbrains.kotlin.jvm" to PluginVersions.kotlin,
        "org.jetbrains.kotlin.plugin.spring" to PluginVersions.kotlin,
        "org.jetbrains.kotlin.plugin.jpa" to PluginVersions.kotlin
    )

    val implementations = listOf(
        "org.springframework.boot:spring-boot-starter-data-jpa",
        "org.springframework.boot:spring-boot-starter-webflux",
        "com.fasterxml.jackson.module:jackson-module-kotlin",
        "io.projectreactor.kotlin:reactor-kotlin-extensions",
        "org.jetbrains.kotlin:kotlin-reflect",
        "org.jetbrains.kotlinx:kotlinx-coroutines-reactor"
    )

    val compileOnly = listOf(
        "org.projectlombok:lombok"
    )

    val annotationProcessor = listOf(
        "org.projectlombok:lombok"
    )

    val testImplementation = listOf(
        "org.springframework.boot:spring-boot-starter-test",
        "io.projectreactor:reactor-test"
    )

}