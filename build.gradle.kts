plugins {
    kotlin("jvm") version "1.6.20"
    `maven-publish`
}

group = "io.github.sp0rk"
version = "0.1.1"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("com.google.truth:truth:1.1.3")
}

tasks.test {
    useJUnitPlatform()
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
            version = "0.3.0"

            from(components["kotlin"])
        }
    }
}