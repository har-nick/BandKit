plugins {
    alias(libs.plugins.dokka) apply false
    alias(libs.plugins.kotlin.multiplatform) apply false
    alias(libs.plugins.ktx.serialization) apply false
    alias(libs.plugins.vanniktech.maven.publish) apply false
}
