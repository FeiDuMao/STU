@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("java")
    alias(libs.plugins.springboot)
    alias(libs.plugins.kotlin.jvm)
    id("java-library")
}



dependencies {

    implementation(libs.slf4j)
    implementation(libs.bundles.jacksonApi)

}


tasks.getByName<Test>("test") {
    useJUnitPlatform()
}



