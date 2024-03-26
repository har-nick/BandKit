package uk.co.harnick.bandkit.data.remote.api

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.header
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import uk.co.harnick.bandkit.data.model.BandcampToken
import uk.co.harnick.bandkit.data.model.LibraryItem
import uk.co.harnick.bandkit.data.model.LibrarySummary
import uk.co.harnick.bandkit.data.model.RequestType.GET
import uk.co.harnick.bandkit.data.model.RequestType.POST
import uk.co.harnick.bandkit.data.model.User
import uk.co.harnick.bandkit.data.model.toLibraryData
import uk.co.harnick.bandkit.data.remote.api.BandKit.ApiResponse.Error.HttpError
import uk.co.harnick.bandkit.data.remote.api.BandKit.ApiResponse.Error.NetworkError
import uk.co.harnick.bandkit.data.remote.api.BandKit.ApiResponse.Error.OkError
import uk.co.harnick.bandkit.data.remote.api.BandKit.ApiResponse.Error.SerializationError
import uk.co.harnick.bandkit.data.remote.api.BandKit.ApiResponse.Success
import uk.co.harnick.bandkit.data.remote.api.BandKit.Common.BASE_URL
import uk.co.harnick.bandkit.data.remote.api.BandKit.Sources.ITEMS
import uk.co.harnick.bandkit.data.remote.api.BandKit.Sources.SUMMARY
import uk.co.harnick.bandkit.data.remote.dto.OkErrorDto
import uk.co.harnick.bandkit.data.remote.dto.items.CollectionItemsRequestBody
import uk.co.harnick.bandkit.data.remote.dto.items.CollectionItemsResponseDto
import uk.co.harnick.bandkit.data.remote.dto.summary.CollectionSummaryResponseDto
import uk.co.harnick.bandkit.util.deserializedRequest
import uk.co.harnick.bandkit.util.scrapedRequest

public object BandKit {
    private val client = HttpClient {
        install(ContentNegotiation) {
            json()
        }
    }

    /** Endpoints for common resources required for library functionality. */
    public object Sources {
        public const val SUMMARY: String = "$BASE_URL/api/fan/2/collection_summary"
        public const val ITEMS: String = "$BASE_URL/api/fancollection/1/collection_items"
        public const val IMAGES: String = "https://f4.bcbits.com/img"
    }

    /** Common endpoints that aren't included in [Sources]. */
    public object Common {
        public const val BASE_URL: String = "https://bandcamp.com"
        public const val FAN_LOGIN: String = "$BASE_URL/login"
        public const val FAN_SIGNUP: String = "$BASE_URL/fansignup"
    }

    public sealed interface ApiResponse<T> {
        public class Success<T>(public val data: T) : ApiResponse<T>

        public sealed class Error(public val reason: String) : ApiResponse<Nothing>, Exception() {
            public class HttpError(public val status: HttpStatusCode) : Error(status.description)
            public class NetworkError(public val error: String) : Error(error)
            public class OkError(internal val dto: OkErrorDto) : Error(dto.errorMessage)
            public class SerializationError(public val error: String) : Error(error)
        }

        /** @throws [ClassCastException] If response is not successful */
        public fun getDataOrThrow(): T = (this as Success).data
        public fun getDataOrNull(): T? = (this as? Success)?.data
    }

    private fun <T, R> ApiResponse<T>.map(transform: (T) -> R): ApiResponse<out R> =
        when (this) {
            is Success -> Success(transform(data))
            is HttpError -> HttpError(status)
            is NetworkError -> NetworkError(error)
            is OkError -> OkError(dto)
            is SerializationError -> SerializationError(error)
        }

    /**
     * Fetches a summary of a user's library.
     * @param [token] Used to authenticate requests.
     * @return An instance of [LibrarySummary] if the response is successful.
     */
    public suspend fun fetchLibrarySummary(token: BandcampToken): ApiResponse<out LibrarySummary> {
        val response = client.deserializedRequest<CollectionSummaryResponseDto>(GET) {
            url(SUMMARY)
            contentType(ContentType.Application.Json)
            header(key = "Cookie", value = "identity=$token")
        }
        return response.map { LibrarySummary(it) }
    }

    /**
     * Fetches a user's detailed library.
     * @param [userId] The ID of the user who's library is being fetched.
     * @param [token] A valid instance of [BandcampToken]. Does not have to be the token of the user who's library you're fetching.
     * @return A list of [library items][LibraryItem] if the response is successful.
     */
    public suspend fun fetchLibraryData(
        userId: Long,
        token: BandcampToken,
    ): ApiResponse<out List<LibraryItem>> {
        val serializedBody = Json.encodeToString(CollectionItemsRequestBody(userId))
        val response = client.deserializedRequest<CollectionItemsResponseDto>(POST) {
            url(ITEMS)
            contentType(ContentType.Application.Json)
            header(key = "Cookie", value = token)
            setBody(serializedBody)
        }
        return response.map { it.toLibraryData() }
    }

    /**
     * Fetches a user's basic account details.
     * @param username The username of the user you wish to fetch. This differs from their [nickname][User.nickname].
     * @return An instance of [LibraryItem] if the [API response][ApiResponse] is [Successful][Success].
     * @see [User]
     */
    public suspend fun fetchUserData(username: String, id: Long): ApiResponse<out User> {
        val response = client.scrapedRequest("$BASE_URL/$username")
        return response.map { pageHtml -> User(pageHtml, id, username) }
    }
}
