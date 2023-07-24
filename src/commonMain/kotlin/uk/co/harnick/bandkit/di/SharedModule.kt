package uk.co.harnick.bandkit.di

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel.INFO
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val sharedModule = module {
    single {
        HttpClient {
            install(Logging) {
                level = INFO
            }
            install(ContentNegotiation) {
                json(Json)
            }

            expectSuccess = true
        }
    }
}
