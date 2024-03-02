package uk.co.harnick.bandkit.util

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*
import io.ktor.utils.io.errors.*
import uk.co.harnick.bandkit.data.model.RequestType
import uk.co.harnick.bandkit.data.model.RequestType.GET
import uk.co.harnick.bandkit.data.model.RequestType.POST
import uk.co.harnick.bandkit.data.remote.api.BandcampApi.Response
import uk.co.harnick.bandkit.data.remote.api.BandcampApi.Response.Error.*
import uk.co.harnick.bandkit.data.remote.api.BandcampApi.Response.Success

internal suspend inline fun <reified T> HttpClient.serializedRequest(
    requestType: RequestType,
    block: HttpRequestBuilder.() -> Unit,
): Response<T> {
    val request = when (requestType) {
        GET -> get { block() }
        POST -> post { block() }
    }

    var hoistedThrow: Throwable?

    return runCatching { Success<T>(request.body()) }
        .getOrElse {
            hoistedThrow = it
            runCatching { OKError<T>(request.body()) }
                .getOrElse { e ->
                    hoistedThrow
                        ?.let { return SerializationError(hoistedThrow!!.localizedMessage) }
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
