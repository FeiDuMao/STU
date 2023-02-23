@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("java")
    alias(libs.plugins.springboot)
    alias(libs.plugins.kotlin.jvm)
    id("java-library")
}



dependencies {

    implementation(project(":common"))

    implementation(project(":stu-starter-edu:stu-starter-edu-core"))
    implementation(project(":stu-starter-edu:stu-starter-edu-jpa"))
    implementation(project(":stu-starter-edu:stu-starter-edu-rest"))
    implementation(project(":stu-starter-edu:stu-starter-edu-integration"))



    implementation(libs.slf4j)
    implementation(platform(libs.springboot.dependencies))
    implementation(libs.springboot.web)
    implementation(libs.springboot.data.jpa)

    implementation(libs.bundles.jacksonApi)

    testImplementation(libs.springboot.test)
    runtimeOnly(libs.mysqlDriver)
    runtimeOnly(libs.springboot.actuator)
}


tasks.getByName<Test>("test") {
    useJUnitPlatform()
}



