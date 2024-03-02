package uk.co.harnick.bandkit.util

import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.utils.io.errors.*
import uk.co.harnick.bandkit.data.remote.api.BandcampApi.Response
import uk.co.harnick.bandkit.data.remote.api.BandcampApi.Response.Error.HttpError
import uk.co.harnick.bandkit.data.remote.api.BandcampApi.Response.Error.NetworkError
import uk.co.harnick.bandkit.data.remote.api.BandcampApi.Response.Success

internal suspend fun <T> HttpClient.scrapedRequest(url: String, block: (String) -> T): Response<T> {
    val request = get(url)

    return runCatching { Success(block(request.bodyAsText())) }
        .getOrElse { e ->
            return when (e) {
                is ClientRequestException -> HttpError(e.response.status.value, e.message)
                is ServerResponseException -> HttpError(e.response.status.value, e.message)
                is IOException -> NetworkError(e.message!!)
                else -> throw e
            }
        }
}
