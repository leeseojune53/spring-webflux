object PluginVersions {
    const val springFramework = "3.1.0"
    const val springDependencyManagement = "1.1.0"
    const val kotlin = "1.8.21"
    const val spotless = "6.11.0"
}

object Libs {

    val plugins = listOf(
        "org.springframework.boot" to PluginVersions.springFramework,
        "io.spring.dependency-management" to PluginVersions.springDependencyManagement,
        "org.jetbrains.kotlin.jvm" to PluginVersions.kotlin,
        "org.jetbrains.kotlin.plugin.spring" to PluginVersions.kotlin,
        "org.jetbrains.kotlin.plugin.jpa" to PluginVersions.kotlin,
        "com.diffplug.spotless" to PluginVersions.spotless,
    )

    val implementations = listOf(
        "org.springframework.boot:spring-boot-starter-webflux",
        "com.fasterxml.jackson.module:jackson-module-kotlin",
        "io.projectreactor.kotlin:reactor-kotlin-extensions",
        "org.jetbrains.kotlin:kotlin-reflect",
        "org.jetbrains.kotlinx:kotlinx-coroutines-reactor",
        "org.springframework.boot:spring-boot-starter-security",
        "io.jsonwebtoken:jjwt:0.9.1",
        "javax.xml.bind:jaxb-api:2.3.1",


        // R2DBC
        "org.springframework.boot:spring-boot-starter-data-r2dbc",
        "com.github.jasync-sql:jasync-r2dbc-mysql:2.1.16"
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