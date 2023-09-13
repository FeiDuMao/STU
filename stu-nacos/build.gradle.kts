@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("java")
    alias(libs.plugins.springboot)
    alias(libs.plugins.kotlin.jvm)
    id("java-library")
}



dependencies {

    implementation(project(":common"))

    implementation(libs.slf4j)
    implementation(platform(libs.springboot.dependencies))
    implementation(libs.springboot.web)
    implementation(libs.guava)

    implementation(libs.bundles.jacksonApi)

    testImplementation(libs.springboot.test)


    runtimeOnly(libs.mysqlDriver)
    implementation(libs.springboot.data.jpa)

}


tasks.getByName<Test>("test") {
    useJUnitPlatform()
}



