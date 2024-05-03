package uk.co.harnick.bandkit.util

import com.github.michaelbull.result.get
import com.github.michaelbull.result.mapError
import com.github.michaelbull.result.runCatching
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.get
import io.ktor.client.request.post
import uk.co.harnick.bandkit.data.model.RequestType
import uk.co.harnick.bandkit.data.model.RequestType.GET
import uk.co.harnick.bandkit.data.model.RequestType.POST
import uk.co.harnick.bandkit.data.remote.api.ApiResponse
import uk.co.harnick.bandkit.data.remote.dto.OkErrorDto

// Bandcamp responds to valid requests with invalid bodies with a 200 Status Code
// To get around it, we need to blindly deserialize and catch until we get the correct output
internal suspend inline fun <reified T> HttpClient.deserializedRequest(
    requestType: RequestType,
    block: HttpRequestBuilder.() -> Unit,
): ApiResponse<T> {
    val response = when (requestType) {
        GET -> get { block() }
        POST -> post { block() }
    }

    return runCatching { response.body<T>() }
        .mapError { e ->
            runCatching { response.body<OkErrorDto>() }
                .get()
                ?.mapToClientRequestException(response)
                ?: e
        }
}
