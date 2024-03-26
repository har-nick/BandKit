plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.dokka)
    id("maven-publish")
}

group = "uk.co.harnick"
version = "1.0-SNAPSHOT"

android {
    compileSdk = 34
    namespace = "uk.co.harnick"
}

kotlin {
    jvmToolchain(libs.versions.jdk.get().toInt())
    withSourcesJar(publish = false)
    explicitApi()

    applyDefaultHierarchyTemplate()
    js(IR) {
        browser()
        nodejs()
    }
    jvm()
    androidTarget()
    iosArm64()
    linuxX64()
    mingwX64("windows")

    sourceSets {
        val windowsMain by getting

        commonMain.dependencies {
            implementation(libs.bundles.ktor)
            implementation(libs.kotlinx.datetime)
        }

        listOf(jvmMain, androidMain, iosMain, linuxMain).forEach { sourceSet ->
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
