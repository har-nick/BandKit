plugins {
    id("java-library")
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlinx.serialization)
}

group = "uk.co.harnick"
version = "1.0-SNAPSHOT"

kotlin {
    explicitApi()
    jvmToolchain(libs.versions.jdk.get().toInt())
}

dependencies {
    implementation(libs.bundles.ktor)
    implementation(libs.kotlinx.datetime)

    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

tasks.test {
    useJUnitPlatform()
}
