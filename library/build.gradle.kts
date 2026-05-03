import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
    alias(libs.plugins.dokka)
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotest)
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.ksp)
    alias(libs.plugins.ktx.serialization)
    alias(libs.plugins.spotless)
    `maven-publish`
}

group = "uk.co.harnick.bandkit"
version = "1.0.0"

kotlin {
    jvmToolchain(libs.versions.jdk.get().toInt())
    explicitApi()
    withSourcesJar(publish = true)

    applyDefaultHierarchyTemplate()

    androidTarget {
        publishLibraryVariants("release")
    }

    jvm()
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    macosArm64()
    linuxX64()
    mingwX64()

    js {
        browser()
        nodejs()
        binaries.library()
        generateTypeScriptDefinitions()

        compilations["main"].packageJson {
            name = "bandkit"
            version = "1.0.0"
            main = "kotlin/bandkit.js"
        }
    }

    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser()
        nodejs()
        binaries.library()
        generateTypeScriptDefinitions()

        compilations["main"].packageJson {
            name = "bandkit"
            version = "1.0.0"
            main = "kotlin/bandkit.js"
        }
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

spotless {
    kotlin {
        ktfmt().googleStyle()
    }
}

// For some unknown eldritch reason, I keep getting a 401 HTTP error when uploading to GitHub packages.
// The only solution I've found was hardcoding my API keys. Any reference causes it.
// Code for reference:
// publishing {
//    repositories {
//        maven {
//            name = "GithubPackages"
//            url = uri("https://maven.pkg.github.com/har-nick/bandkit")
//
//            credentials {
//                username = ""
//                password = ""
//            }
//        }
//    }
//}
apply(from = "publish.gradle.kts")
