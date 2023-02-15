@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("java")
    alias(libs.plugins.kotlin.jvm)
    id("java-library")
}



dependencies {

    implementation(project(":common"))

    implementation(libs.slf4j)

    implementation(libs.junit.api)
    implementation(libs.junit.engine)
    implementation(libs.mockito.core)
    implementation(libs.mockito.kotlin)

    implementation(libs.bundles.jacksonApi)

    implementation(libs.jmh.core)
    annotationProcessor(libs.jmh.generator.annprocess)


}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}