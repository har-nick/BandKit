package uk.co.harnick.bandkit.util

import io.ktor.client.HttpClient
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.utils.io.errors.IOException
import uk.co.harnick.bandkit.data.remote.api.BandKit.ApiResponse
import uk.co.harnick.bandkit.data.remote.api.BandKit.ApiResponse.Error.HttpError
import uk.co.harnick.bandkit.data.remote.api.BandKit.ApiResponse.Error.NetworkError
import uk.co.harnick.bandkit.data.remote.api.BandKit.ApiResponse.Success

internal suspend fun HttpClient.scrapedRequest(url: String): ApiResponse<String> {
    val request = get(url)

    return runCatching { Success(request.bodyAsText()) }
        .getOrElse { e ->
            throw when (e) {
                is ClientRequestException -> HttpError(e.response.status)
                is ServerResponseException -> HttpError(e.response.status)
                is IOException -> NetworkError(e.message!!)
                else -> throw e
            }
        }
}
