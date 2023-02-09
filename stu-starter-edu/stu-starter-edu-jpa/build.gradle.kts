@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("java")
    alias(libs.plugins.springboot)
    alias(libs.plugins.kotlin.jvm)
    id("java-library")
}



dependencies {

    api(project(":stu-starter-edu:stu-starter-edu-core"))

    implementation(libs.slf4j)

    implementation(libs.springboot.jdbc)
    implementation(libs.springboot.data.jpa)
    implementation(platform(libs.springboot.dependencies))
}


tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
    }
}




