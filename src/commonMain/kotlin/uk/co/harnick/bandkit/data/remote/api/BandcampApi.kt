package uk.co.harnick.bandkit.data.remote.api

import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import uk.co.harnick.bandkit.data.model.ImageSize
import uk.co.harnick.bandkit.data.model.ImageSize.Small
import uk.co.harnick.bandkit.data.model.RequestType.GET
import uk.co.harnick.bandkit.data.model.RequestType.POST
import uk.co.harnick.bandkit.data.remote.api.BandcampApi.Common.BASE_URL
import uk.co.harnick.bandkit.data.remote.api.BandcampApi.Sources.IMAGES
import uk.co.harnick.bandkit.data.remote.api.BandcampApi.Sources.ITEMS
import uk.co.harnick.bandkit.data.remote.api.BandcampApi.Sources.SUMMARY
import uk.co.harnick.bandkit.data.remote.dto.BandcampUser
import uk.co.harnick.bandkit.data.remote.dto.ErrorResponseDto
import uk.co.harnick.bandkit.data.remote.dto.items.CollectionItemsRequestBody
import uk.co.harnick.bandkit.data.remote.dto.items.CollectionItemsResponseDto
import uk.co.harnick.bandkit.data.remote.dto.summary.CollectionSummaryResponseDto
import uk.co.harnick.bandkit.util.scrapedRequest
import uk.co.harnick.bandkit.util.serializedRequest

public object BandcampApi {
    private val client = HttpClient {
        install(ContentNegotiation) {
            json()
        }
    }

    public object Sources {
        public const val SUMMARY: String = "$BASE_URL/api/fan/2/collection_summary"
        public const val ITEMS: String = "$BASE_URL/api/fancollection/1/collection_items"
        public const val IMAGES: String = "https://f4.bcbits.com/img"
    }

    public object Common {
        public const val BASE_URL: String = "https://bandcamp.com"
        public const val FAN_LOGIN: String = "$BASE_URL/login"
        public const val FAN_SIGNUP: String = "$BASE_URL/fansignup"
    }

    public sealed interface Response<T> {
        public data class Success<T>(val data: T) : Response<T>

        public sealed class Error<T>(public val cause: String) : Response<T> {
            public data class HttpError<T>(val code: Int, val error: String) : Error<T>(error)
            public data class NetworkError<T>(val error: String) : Error<T>(error)
            // Bandcamp returns all request errors as JSON with a 200 (OK) header. I hate it.
            public data class OKError<T>(val errorDto: ErrorResponseDto) : Error<T>(errorDto.errorMessage)
            public data class SerializationError<T>(val error: String) : Error<T>(error)
        }
    }

    public fun albumArtUrl(id: Long, size: ImageSize = Small): String = IMAGES + "/a${id}_" + size.apiParam
    public fun profileAvatarUrl(id: Long, size: ImageSize = Small): String = IMAGES + "/${id}_" + size.apiParam

    public suspend fun fetchLibrarySummary(token: String): Response<CollectionSummaryResponseDto> =
        client.serializedRequest(GET) {
            url(SUMMARY)
            contentType(ContentType.Application.Json)
            header(key = "Cookie", value = "identity=$token")
        }

    public suspend fun fetchLibraryData(
        token: String,
        userId: Long,
        itemCount: Int
    ): Response<CollectionItemsResponseDto> {
        val serializedBody = Json.encodeToString(CollectionItemsRequestBody(userId, itemCount))
        return client.serializedRequest(POST) {
            url(ITEMS)
            contentType(ContentType.Application.Json)
            header(key = "Cookie", value = token)
            setBody(serializedBody)
        }
    }

    public suspend fun fetchUserData(username: String): Response<BandcampUser> =
        client.scrapedRequest("$BASE_URL/$username") { body -> BandcampUser(body, username) }
}
