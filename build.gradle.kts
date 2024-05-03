plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.dokka)
    id("maven-publish")
}

group = "uk.co.harnick"
version = "1.0-SNAPSHOT"

kotlin {
    jvmToolchain(libs.versions.jdk.get().toInt())
    explicitApi()
    withSourcesJar(publish = true)

    applyDefaultHierarchyTemplate()
    js(IR) {
        browser()
        nodejs()
    }
    jvm()
    iosArm64()
    linuxX64()
    mingwX64("windows")

    sourceSets {
        val windowsMain by getting

        commonMain.dependencies {
            implementation(libs.bundles.ktor)
            api(libs.kotlin.result)
            implementation(libs.kotlinx.datetime)
        }

        listOf(jvmMain, iosMain, linuxMain).forEach { sourceSet ->
            sourceSet.dependencies {
                implementation(libs.ktor.engine.cio)
            }
        }

        jsMain.dependencies {
            implementation(libs.ktor.engine.js)
        }

        windowsMain.dependencies {
            implementation(libs.ktor.engine.winhttp)
        }
    }
}

publishing {
    repositories {
        maven {
            name = "BandKit"
            url = uri("https://maven.pkg.github.com/har-nick/bandkit")
            credentials {
                username = System.getenv("GH_USERNAME")
                password = System.getenv("GH_TOKEN_PACKAGE_PUBLISHING")
            }
        }
    }
}
