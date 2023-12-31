plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.dokka)
    id("maven-publish")
}

group = "uk.co.harnick"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

@Suppress("UnusedPrivateProperty")
kotlin {
    java {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "17"
        }
        withJava()
        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
        }
    }
    js(IR) {
        binaries.executable()
        browser()
        nodejs()
    }
    val hostOs = System.getProperty("os.name")
    val isMingwX64 = hostOs.startsWith("Windows")
    val nativeTarget = when {
        hostOs == "Mac OS X" -> macosX64("native")
        hostOs == "Linux" -> linuxX64("native")
        isMingwX64 -> mingwX64("native")
        else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.koin.core)
                implementation(libs.kotlinx.datetime)
                implementation(libs.ktor.content.negotiation)
                implementation(libs.ktor.core)
                implementation(libs.ktor.logging)
                implementation(libs.ktor.serialization.json)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }

        val jvmMain by getting {
            dependencies {
                implementation(libs.ktor.engine.cio)
                implementation(libs.slf4j.simple)
            }
        }
        val jvmTest by getting

        val jsMain by getting {
            dependencies {
                implementation(libs.ktor.engine.js)
            }
        }
        val jsTest by getting

        val nativeMain by getting {
            dependencies {
                when (isMingwX64) {
                    true -> implementation(libs.ktor.engine.winhttp)
                    false -> implementation(libs.ktor.engine.cio)
                }
            }
        }
        val nativeTest by getting
    }
}
