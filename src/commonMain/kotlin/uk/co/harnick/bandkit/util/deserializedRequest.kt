package uk.co.harnick.bandkit.util

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.ResponseException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.utils.io.errors.IOException
import uk.co.harnick.bandkit.data.model.RequestType
import uk.co.harnick.bandkit.data.model.RequestType.GET
import uk.co.harnick.bandkit.data.model.RequestType.POST
import uk.co.harnick.bandkit.data.remote.api.BandKit.ApiResponse
import uk.co.harnick.bandkit.data.remote.api.BandKit.ApiResponse.Error.HttpError
import uk.co.harnick.bandkit.data.remote.api.BandKit.ApiResponse.Error.NetworkError
import uk.co.harnick.bandkit.data.remote.api.BandKit.ApiResponse.Error.OkError
import uk.co.harnick.bandkit.data.remote.api.BandKit.ApiResponse.Error.SerializationError
import uk.co.harnick.bandkit.data.remote.api.BandKit.ApiResponse.Success

// Bandcamp responds to valid requests with invalid bodies with a 200 Status Code
// To get around it, we need to blindly serialize and catch until we get the correct output
internal suspend inline fun <reified T> HttpClient.deserializedRequest(
    requestType: RequestType,
    block: HttpRequestBuilder.() -> Unit,
): ApiResponse<out T> {
    val request = when (requestType) {
        GET -> get { block() }
        POST -> post { block() }
    }

    var okError: Throwable?

    return runCatching { Success<T>(request.body()) }
        .recoverCatching { e ->
            okError = e
            runCatching { OkError(request.body()) }
                .getOrElse {
                    okError
                        ?.let { throw SerializationError(it.message!!) }
                        ?: throw when (e) {
                            is ClientRequestException, is ServerResponseException ->
                                HttpError(status = (e as? ResponseException)!!.response.status)

                            is IOException -> NetworkError(e.message!!)
                            else -> e
                        }
                }
        }
        .getOrThrow()
}
