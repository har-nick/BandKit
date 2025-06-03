package uk.co.harnick.bandkit.core

import io.ktor.client.call.body
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.accept
import io.ktor.client.request.request
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.http.ContentType
import io.ktor.http.HttpMethod
import io.ktor.http.contentType
import io.ktor.serialization.ContentConvertException
import uk.co.harnick.bandkit.core.BandKitException.ApiException
import uk.co.harnick.bandkit.core.dto.ApiError

internal suspend inline fun <reified Data, reified Error> BandKit.getApiResponse(
    url: String,
    httpMethod: HttpMethod,
    body: String? = null,
    config: HttpRequestBuilder.() -> Unit = {}
): Data {
    val response = client.request {
        url(url)
        contentType(ContentType.Application.Json)
        accept(ContentType.Any)
        method = httpMethod
        if (body != null) setBody(body)
        config()
    }

    // API errors are returned with a 200 (OK) status code, so we need naively to deserialize and catch
    return try {
        response.body<Data>()
    } catch (e: ContentConvertException) {
        val apiError = response.body<Error>() as ApiError
        throw ApiException(apiError.message)
    }
}
