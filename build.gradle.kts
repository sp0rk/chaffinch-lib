plugins {
    kotlin("jvm") version "1.6.20"
    `maven-publish`
    jacoco
}

group = "io.github.sp0rk"
version = Config.Versions.lib

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("com.google.truth:truth:1.1.3")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "io.github.sp0rk"
            artifactId = "chaffinch-lib"
            version = Config.Versions.lib

            from(components["kotlin"])
        }
    }
}

tasks.test {
    reports {
        junitXml.required.set(true)
        junitXml.isEnabled = true
    }
}

jacoco {
    toolVersion = "0.8.7"
}
tasks.withType<JacocoReport> {
    reports {
        xml.required.set(true)
        xml.isEnabled = true
        csv.required.set(true)
        csv.isEnabled = true
        html.required.set(true)
        html.isEnabled = true
    }

    val excludes = listOf(
        "**/*Test*.*",
        "**/actions/*.*",
        "**/core/*.*",
        "**/markers/*.*",
        "**/services/**/*.*",
        "**/toolwindow/*.*",
        "**/utils/*.*"
    )

    val javaClasses = fileTree("$buildDir/classes/java/main") { exclude(*excludes.toTypedArray()) }
    val kotlinClasses = fileTree("$buildDir/classes/kotlin/main") { exclude(*excludes.toTypedArray()) }
    classDirectories.from(javaClasses, kotlinClasses)
    sourceDirectories.from(
        "$project.projectDir/src/main/java",
        "$project.projectDir/src/main/kotlin",
        "$buildDir/generated/source/kapt/test"
    )

    executionData("${project.buildDir}/jacoco/test.exec")
}
