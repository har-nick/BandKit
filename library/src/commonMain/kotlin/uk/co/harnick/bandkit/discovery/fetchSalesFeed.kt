package uk.co.harnick.bandkit.discovery

import io.ktor.http.ContentType.Application.Json
import io.ktor.http.HttpMethod.Companion.Get
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import uk.co.harnick.bandkit.core.BandKit
import uk.co.harnick.bandkit.core.BandKit.Companion.BASE_URL
import uk.co.harnick.bandkit.core.dto.ApiError
import uk.co.harnick.bandkit.discovery.dto.salesfeed.SalesFeedResponse
import uk.co.harnick.bandkit.discovery.util.UnstableApi
import uk.co.harnick.bandkit.util.fetchApiResponse
import kotlin.time.Clock
import kotlin.time.ExperimentalTime

/**
 * Fetches the sales feed from the main page.
 * @return A Flow of [SalesFeedResponse].
 */
@UnstableApi("This function has improper error-typing, as I'm unable to get an error from the API.")
@OptIn(ExperimentalTime::class)
public fun BandKit.fetchSalesFeed(): Flow<SalesFeedResponse> {
    val url = "$BASE_URL/api/salesfeed/1/get"
    var cursor = Clock.System.now().epochSeconds

    return flow {
        while (true) {
            val response = fetchApiResponse<SalesFeedResponse, ApiError>(
                url = "${url}?start_date=$cursor",
                httpMethod = Get,
                contentType = Json,
            )

            cursor = response.endDate

            emit(response)
        }
    }
}
