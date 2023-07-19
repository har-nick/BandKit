package uk.co.harnick.bandkit.data

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.koin.core.component.inject
import uk.co.harnick.bandkit.data.BandcampApi.Urls.BASE_URL
import uk.co.harnick.bandkit.data.BandcampApi.Urls.ITEMS
import uk.co.harnick.bandkit.data.BandcampApi.Urls.SUMMARY
import uk.co.harnick.bandkit.data.model.CollectionItemsRequestBody
import uk.co.harnick.bandkit.data.remote.items.CollectionItemsResponseDto
import uk.co.harnick.bandkit.data.remote.summary.CollectionSummaryResponseDto
import uk.co.harnick.bandkit.di.BandKitKoinComponent
import uk.co.harnick.bandkit.domain.model.BandcampUser

object BandcampApi : BandKitKoinComponent() {
    private val client by inject<HttpClient>()

    private object Urls {
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

        return BandcampUser(username, nickname = null, avatarId, bannerId, followerCount, followingCount)
    }
}
