package uk.co.harnick.bandkit.util

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.utils.io.errors.IOException
import uk.co.harnick.bandkit.data.model.RequestType
import uk.co.harnick.bandkit.data.model.RequestType.GET
import uk.co.harnick.bandkit.data.model.RequestType.POST
import uk.co.harnick.bandkit.data.remote.api.BandcampApi.Response
import uk.co.harnick.bandkit.data.remote.api.BandcampApi.Response.Error.HttpError
import uk.co.harnick.bandkit.data.remote.api.BandcampApi.Response.Error.NetworkError
import uk.co.harnick.bandkit.data.remote.api.BandcampApi.Response.Error.OKError
import uk.co.harnick.bandkit.data.remote.api.BandcampApi.Response.Error.SerializationError
import uk.co.harnick.bandkit.data.remote.api.BandcampApi.Response.Success

internal suspend inline fun <reified T> HttpClient.serializedRequest(
    requestType: RequestType,
    block: HttpRequestBuilder.() -> Unit,
): Response<T> {
    val request = when (requestType) {
        GET -> get { block() }
        POST -> post { block() }
    }

    var okError: Throwable?

    return runCatching { Success<T>(request.body()) }
        .getOrElse {
            okError = it
            runCatching { OKError<T>(request.body()) }
                .getOrElse { e ->
                    okError
                        ?.let { return SerializationError(it.message!!) }
                        ?: when (e) {
                            is ClientRequestException -> HttpError(
                                e.response.status.value,
                                e.message
                            )

                            is ServerResponseException -> HttpError(
                                e.response.status.value,
                                e.message
                            )

                            is IOException -> NetworkError(e.message!!)
                            else -> throw e
                        }
                }
        }
}
