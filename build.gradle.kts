plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlinx.serialization)
    id("maven-publish")
}

group = "uk.co.harnick"
version = "1.0-SNAPSHOT"

android {
    compileSdk = 34
    namespace = "some.namespace.previously.in.android.manifest"
    defaultConfig {
        minSdk = 24
        compileSdk = 34
    }
}

kotlin {
    jvmToolchain(libs.versions.jdk.get().toInt())
    withSourcesJar(publish = false)
    explicitApi()

    applyDefaultHierarchyTemplate()
    js {
        browser()
        nodejs()
    }
    jvm()
    androidTarget()
    iosArm64()
    linuxArm64()
    mingwX64("windows")

    sourceSets {
        val windowsMain by getting

        commonMain.dependencies {
            implementation(libs.bundles.ktor)
            implementation(libs.kotlinx.datetime)
        }

        listOf(jvmMain, androidMain, iosMain, linuxMain).forEach {
            it.dependencies {
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
