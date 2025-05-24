plugins {
    alias(libs.plugins.dokka)
    alias(libs.plugins.kotlin.multiplatform)
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
    js {
        browser()
        nodejs()
    }
    jvm()
    iosArm64()
    linuxX64()
    mingwX64("windows")

    sourceSets {
        commonMain.dependencies {
            implementation(libs.bundles.ktor)

            implementation(libs.kotlinx.datetime)
        }

        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}
