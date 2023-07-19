package uk.co.harnick.bandkit.di

import io.ktor.client.HttpClient
import org.koin.dsl.module

val sharedModule = module {
    single { HttpClient() }
}
