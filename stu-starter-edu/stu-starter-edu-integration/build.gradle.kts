@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("java")
    alias(libs.plugins.springboot)
    alias(libs.plugins.kotlin.jvm)
    id("java-library")
}



dependencies {



    implementation(libs.slf4j)
    implementation(platform(libs.springboot.dependencies))
    implementation(libs.springboot.web)
    implementation(libs.springboot.data.jpa)

    implementation(libs.bundles.jacksonApi)
}


tasks.getByName<Test>("test") {
    useJUnitPlatform()
}



