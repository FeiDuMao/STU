pluginManagement {
    repositories {
        mavenLocal()
        mavenCentral()
    }
}
rootProject.name = "TYY"


include("stu-svc-app")
include("stu-basic")

include(
    "stu-starter-edu:stu-starter-edu-core",
    "stu-starter-edu:stu-starter-edu-jpa",
    "stu-starter-edu:stu-starter-edu-rest",
    "stu-starter-edu:stu-starter-edu-integration"
)