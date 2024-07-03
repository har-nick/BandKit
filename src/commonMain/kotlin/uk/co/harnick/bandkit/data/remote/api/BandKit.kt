package uk.co.harnick.bandkit.data.remote.api

import com.github.michaelbull.result.Result
import com.github.michaelbull.result.map
import com.github.michaelbull.result.runCatching
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import uk.co.harnick.bandkit.data.model.ArtistFollowee
import uk.co.harnick.bandkit.data.model.BandcampToken
import uk.co.harnick.bandkit.data.model.FanFollowee
import uk.co.harnick.bandkit.data.model.Follower
import uk.co.harnick.bandkit.data.model.LibraryItem
import uk.co.harnick.bandkit.data.model.LibrarySummary
import uk.co.harnick.bandkit.data.model.RequestType.GET
import uk.co.harnick.bandkit.data.model.RequestType.POST
import uk.co.harnick.bandkit.data.model.User
import uk.co.harnick.bandkit.data.model.toArtistFollowee
import uk.co.harnick.bandkit.data.model.toFanFollowee
import uk.co.harnick.bandkit.data.model.toFollower
import uk.co.harnick.bandkit.data.model.toLibraryItems
import uk.co.harnick.bandkit.data.remote.api.BandKit.Common.BASE_URL
import uk.co.harnick.bandkit.data.remote.api.BandKit.Sources.FOLLOWERS
import uk.co.harnick.bandkit.data.remote.api.BandKit.Sources.ITEMS
import uk.co.harnick.bandkit.data.remote.api.BandKit.Sources.SUMMARY
import uk.co.harnick.bandkit.data.remote.dto.followee.band.ArtistFolloweeResponseDto
import uk.co.harnick.bandkit.data.remote.dto.followee.fan.FanFolloweeResponseDto
import uk.co.harnick.bandkit.data.remote.dto.follower.FollowersRequestBody
import uk.co.harnick.bandkit.data.remote.dto.follower.FollowersResponseDto
import uk.co.harnick.bandkit.data.remote.dto.items.CollectionItemsRequestBodyDto
import uk.co.harnick.bandkit.data.remote.dto.items.CollectionItemsResponseDto
import uk.co.harnick.bandkit.data.remote.dto.summary.CollectionSummaryResponseDto
import uk.co.harnick.bandkit.util.deserializedRequest

public typealias ApiResponse<T> = Result<T, Throwable>

@Suppress("UNUSED")
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
        public const val FOLLOWERS: String = "$BASE_URL/api/fancollection/1/followers"
    }

    /** Common endpoints that aren't included in [Sources]. */
    public object Common {
        public const val BASE_URL: String = "https://bandcamp.com"
        public const val FAN_LOGIN: String = "$BASE_URL/login"
        public const val FAN_SIGNUP: String = "$BASE_URL/fansignup"
    }

    /**
     * Fetches a summary of a user's library.
     * @param [token] Used to authenticate requests.
     * @return An instance of [LibrarySummary] if the response is successful.
     */
    public suspend fun fetchLibrarySummary(token: BandcampToken): ApiResponse<LibrarySummary> {
        val tokenValue = token.token

        return client.deserializedRequest<CollectionSummaryResponseDto>(GET) {
            url(SUMMARY)
            contentType(ContentType.Application.Json)
            header(key = "Cookie", value = "identity=$tokenValue")
        }
            .map { LibrarySummary(it) }
    }

    /**
     * Fetches a user's detailed library.
     * @param [userId] The ID of the user who's library is being fetched.
     * @param [token] An instance of [BandcampToken]
     * @return A list of [library items][LibraryItem] if the response is successful.
     */
    public suspend fun fetchLibraryItems(
        userId: Long,
        token: BandcampToken,
    ): ApiResponse<List<LibraryItem>> {
        val serializedBody = Json.encodeToString(CollectionItemsRequestBodyDto(userId))
        val tokenValue = token.token

        return client
            .deserializedRequest<CollectionItemsResponseDto>(POST) {
                url(ITEMS)
                contentType(ContentType.Application.Json)
                header(key = "Cookie", value = "identity=$tokenValue")
                setBody(serializedBody)
            }
            .map { it.toLibraryItems() }
    }

    /**
     * Fetches a user's profile details.
     * @param [username] The username of the user you wish to fetch. This differs from their [nickname][User.displayName].
     * @return An instance of [LibraryItem] if the [API response][ApiResponse] is successful.
     * @see [User]
     */
    public suspend fun fetchUser(userId: Long, username: String): ApiResponse<User> {
        return runCatching { client.get("$BASE_URL/$username").bodyAsText() }
            .map { pageHtml -> User(pageHtml, userId, username) }
    }

    public suspend fun fetchFollowers(userId: Long): ApiResponse<List<Follower>> {
        val serializedBody = Json.encodeToString(FollowersRequestBody(userId))

        return client
            .deserializedRequest<FollowersResponseDto>(POST) {
                url(FOLLOWERS)
                contentType(ContentType.Application.Json)
                setBody(serializedBody)
            }
            .map { it.followers.map { dto -> dto.toFollower() } }
    }

    public suspend fun fetchFollowedArtists(userId: Long): ApiResponse<List<ArtistFollowee>> {
        val serializedBody = Json.encodeToString(FollowersRequestBody(userId))

        return client
            .deserializedRequest<ArtistFolloweeResponseDto>(POST) {
                url(FOLLOWERS)
                contentType(ContentType.Application.Json)
                setBody(serializedBody)
            }
            .map { it.followees.map { dto -> dto.toArtistFollowee() } }
    }

    public suspend fun fetchFollowedFans(userId: Long): ApiResponse<List<FanFollowee>> {
        val serializedBody = Json.encodeToString(FollowersRequestBody(userId))

        return client
            .deserializedRequest<FanFolloweeResponseDto>(POST) {
                url(FOLLOWERS)
                contentType(ContentType.Application.Json)
                setBody(serializedBody)
            }
            .map { it.followees.map { dto -> dto.toFanFollowee() } }
    }
}
