@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("java")
    alias(libs.plugins.kotlin.jvm)
    id("java-library")
}



dependencies {
    implementation(libs.junit.api)
    implementation(libs.junit.engine)
    implementation(libs.mockito.core)
    implementation(libs.mockito.kotlin)
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}