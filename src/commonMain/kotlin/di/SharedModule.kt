package di

import data.BandcampApi
import io.ktor.client.HttpClient
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val sharedModule = module {
    single { HttpClient() }
    singleOf(::BandcampApi)
}
