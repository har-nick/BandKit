package uk.co.harnick.bandkit.di

import org.koin.dsl.koinApplication

object BandKitKoinContext {
    val koinApp = koinApplication {
        modules(sharedModule)
    }

    val koin = koinApp.koin
}