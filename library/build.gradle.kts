import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
    alias(libs.plugins.dokka)
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotest)
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.ksp)
    alias(libs.plugins.ktx.serialization)
    alias(libs.plugins.vanniktech.maven.publish)
}

group = "uk.co.harnick"
version = "1.0.0"

kotlin {
    jvmToolchain(libs.versions.jdk.get().toInt())
    explicitApi()
    withSourcesJar(publish = true)

    applyDefaultHierarchyTemplate()

    androidTarget { publishLibraryVariants("release") }
    jvm()
    js { browser() }
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    macosArm64()
    linuxX64()
    mingwX64()

    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser()
        binaries.executable()
    }

    sourceSets {
        commonMain.dependencies {
            implementation(libs.bundles.ktor)

            implementation(libs.kotlinx.datetime)
            implementation(libs.ksoup)
        }

        commonTest.dependencies {
            implementation(libs.kotlin.test)
            implementation(libs.kotest.framework)
        }
    }
}

android {
    namespace = "uk.co.harnick.bandkit"
    compileSdk = 36

    defaultConfig {
        minSdk = 14
    }
}
