plugins {
    alias(libs.plugins.dokka) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotest) apply false
    alias(libs.plugins.kotlin.multiplatform) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.ktx.serialization) apply false
    alias(libs.plugins.vanniktech.maven.publish) apply false
    alias(libs.plugins.spotless) apply false
}
