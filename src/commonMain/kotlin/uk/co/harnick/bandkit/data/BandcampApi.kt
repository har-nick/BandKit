package uk.co.harnick.bandkit.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.client.statement.request
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.JsonConvertException
import kotlinx.serialization.SerializationException
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.koin.core.component.inject
import uk.co.harnick.bandkit.data.BandcampApi.Sources.BASE_URL
import uk.co.harnick.bandkit.data.BandcampApi.Sources.ITEMS
import uk.co.harnick.bandkit.data.BandcampApi.Sources.SUMMARY
import uk.co.harnick.bandkit.data.model.CollectionItemsRequestBody
import uk.co.harnick.bandkit.data.remote.ErrorResponseDto
import uk.co.harnick.bandkit.data.remote.items.CollectionItemsResponseDto
import uk.co.harnick.bandkit.data.remote.summary.CollectionSummaryResponseDto
import uk.co.harnick.bandkit.di.BandKitKoinComponent
import uk.co.harnick.bandkit.domain.model.BandKitException.TokenException
import uk.co.harnick.bandkit.domain.model.BandKitException.UnknownException
import uk.co.harnick.bandkit.domain.model.BandcampUser

object BandcampApi : BandKitKoinComponent() {
    private val client by inject<HttpClient>()

    object Sources {
        const val BASE_URL = "https://bandcamp.com"
        const val SUMMARY = "$BASE_URL/api/fan/2/collection_summary"
        const val ITEMS = "$BASE_URL/api/fancollection/1/collection_items"
        const val ART = "https://f4.bcbits.com/img"
    }

    // Bandcamp (barring a server issue) serves all content and errors with a 2xx status code.
    // We need to naively serialize as the intended type, then again as an error if it's thrown.
    private suspend inline fun <reified T> HttpResponse.serializeWorkaround(): T {
        try {
            return this.body()
        } catch (e: JsonConvertException) {
            val errorDto: ErrorResponseDto = this.body()

            when (errorDto.errorMessage) {
                "must be logged in" -> throw TokenException
                else -> throw UnknownException
            }
        } catch (e: JsonConvertException) {
            throw SerializationException("Failed to serialize ${this.request.url}'s body.")
        }
    }

    suspend fun fetchSummary(token: String): CollectionSummaryResponseDto {
        return client.get(SUMMARY) {
            contentType(ContentType.Application.Json)
            header(key = "Cookie", value = "identity=$token")
        }.serializeWorkaround()
    }

    suspend fun fetchItems(
        token: String,
        userId: Long,
        itemCount: Int
    ): CollectionItemsResponseDto {
        val serializedBody = Json.encodeToString(CollectionItemsRequestBody(userId, itemCount))

        return client.post(ITEMS) {
            contentType(ContentType.Application.Json)
            header(key = "Cookie", value = token)
            setBody(Json.encodeToString(serializedBody))
        }.serializeWorkaround()
    }

    suspend fun fetchUser(username: String): BandcampUser {
        val accountPage = client.get("$BASE_URL/$username").bodyAsText()

        val followingCount = accountPage
            .substringAfter("<li data-tab=\"following\"")
            .substringAfter("<span class=\"count\">")
            .substringBefore("</span>")
            .toIntOrNull() ?: 0

        val followerCount = accountPage
            .substringAfter("<li data-tab=\"followers\"")
            .substringAfter("<span class=\"count\">")
            .substringBefore("</span>")
            .toIntOrNull() ?: 0

        val avatarId = accountPage
            .substringAfter("<a class=\"popupImage\" href=\"https://f4.bcbits.com/img/")
            .substringBefore("_")
            .toLongOrNull()

        val bannerId = accountPage
            .substringAfter(".fan-banner")
            .substringAfter("img/")
            .substringBefore("_")
            .toLongOrNull()

        return BandcampUser(
            username,
            nickname = null,
            avatarId,
            bannerId,
            followerCount,
            followingCount
        )
    }
}
