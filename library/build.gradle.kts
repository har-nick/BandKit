import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import java.util.Properties

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

group = "uk.co.harnick"
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

publishing {
    val secrets = Properties().apply {
        load(rootProject.file("secrets.properties").reader())
    }

    repositories {
        maven {
            name = "GithubPackages"
            url = uri("https://maven.pkg.github.com/har-nick/bandkit")

            credentials {
                username = secrets["gpr.user"] as? String ?: System.getenv("GITHUB_USER")
                password = secrets["gpr.key"] as? String ?: System.getenv("GITHUB_TOKEN")
            }
        }
    }

    publications {
        withType<MavenPublication>().configureEach {
            groupId = "$group"
            version = "$version"

            pom {
                name = "BandKit"
                description = "A Kotlin Multiplatform library to interface with Bandcamp's API."
                url = "https://github.com/har-nick/bandkit"

                licenses {
                    license {
                        name = "Apache-2.0"
                        url = "https://opensource.org/licenses/Apache-2.0"
                    }
                }

                scm {
                    connection = "scm:git:git://github.com/har-nick/bandkit.git"
                    developerConnection = "scm:git:ssh://github.com/har-nick/bandkit.git"
                    url = "https://github.com/har-nick/bandkit"
                }
            }
        }
    }
}
