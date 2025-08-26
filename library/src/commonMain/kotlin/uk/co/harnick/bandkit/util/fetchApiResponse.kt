package uk.co.harnick.bandkit.util

import io.ktor.client.call.body
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.accept
import io.ktor.client.request.cookie
import io.ktor.client.request.request
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.http.ContentType
import io.ktor.http.HttpMethod
import io.ktor.http.contentType
import io.ktor.http.userAgent
import io.ktor.serialization.ContentConvertException
import uk.co.harnick.bandkit.core.BandKit
import uk.co.harnick.bandkit.core.BandKitException.ApiException
import uk.co.harnick.bandkit.core.dto.ApiError

internal suspend inline fun <reified Data, reified Error : ApiError> BandKit.fetchApiResponse(
    url: String,
    httpMethod: HttpMethod,
    token: String? = null,
    body: String? = null,
    config: HttpRequestBuilder.() -> Unit = {}
): Data {
    val response = client.request {
        url(url)
        contentType(ContentType.Application.Json)
        userAgent(this@fetchApiResponse.config.userAgent)
        accept(ContentType.Any)
        method = httpMethod

        if (token != null) cookie(
            name = "identity",
            value = token,
            domain = ".bandcamp.com",
            secure = true,
            httpOnly = true
        )

        if (body != null) setBody(body)
        config()
    }

    // API errors are returned with a 200 (OK) status code, so we need naively to deserialize and catch
    return try {
        response.body<Data>()
    } catch (e: ContentConvertException) {
        val apiError = response.body<Error>()
        throw ApiException(apiError.message)
    }
}
