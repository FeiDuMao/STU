plugins {
    id("java")
}

allprojects {

    configurations.all {
        exclude("org.apache.logging.log4j")
    }

    group = "com.tyy.stu"
    version = "1.0-SNAPSHOT"


    apply(plugin = "java")

    java {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    tasks.withType<JavaCompile>() {
        options.encoding = "utf-8"
    }

    tasks.withType<Test>() {
        useJUnitPlatform()
    }

    dependencies {
        compileOnly(rootProject.libs.lombok)
        annotationProcessor(rootProject.libs.lombok)
        testCompileOnly(rootProject.libs.lombok)
        testAnnotationProcessor(rootProject.libs.lombok)
        testImplementation(rootProject.libs.junit.api)
        testRuntimeOnly(rootProject.libs.junit.engine)
    }

    repositories {

        maven {
            url = uri("https://maven.aliyun.com/repository/public/")
        }
        maven {
            url = uri("https://maven.aliyun.com/repository/central/")
        }
        maven {
            url = uri("https://maven.aliyun.com/repository/jcenter/")
        }
        maven {
            url = uri("https://maven.aliyun.com/repository/spring/")
        }
        mavenLocal()
        mavenCentral()
    }


}
