package data

import data.model.CollectionItemsRequestBody
import data.remote.items.CollectionItemsResponseDto
import data.remote.summary.CollectionSummaryResponseDto
import di.BandKitKoinComponent
import domain.model.BandcampUser
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.koin.core.component.inject

class BandcampApi : BandKitKoinComponent() {
    private val client by inject<HttpClient>()

    private companion object {
        const val BASE_URL = "https://bandcamp.com"
        const val SUMMARY = "$BASE_URL/api/fan/2/collection_summary"
        const val ITEMS = "$BASE_URL/api/fancollection/1/collection_items"
    }

    suspend fun fetchSummary(token: String): CollectionSummaryResponseDto {
        return client.get(SUMMARY) {
            contentType(ContentType.Application.Json)
            header(key = "Cookie", value = "identity=$token")
        }.body()
    }

    suspend fun fetchItems(
        token: String,
        body: CollectionItemsRequestBody
    ): CollectionItemsResponseDto {
        return client.post(ITEMS) {
            contentType(ContentType.Application.Json)
            header(key = "Cookie", value = token)
            setBody(Json.encodeToString(body))
        }.body()
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
