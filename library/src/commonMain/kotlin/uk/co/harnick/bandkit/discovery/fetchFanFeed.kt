package uk.co.harnick.bandkit.discovery

import io.ktor.http.HttpMethod
import io.ktor.util.date.getTimeMillis
import kotlinx.serialization.json.Json
import uk.co.harnick.bandkit.core.BandKit
import uk.co.harnick.bandkit.core.BandKit.Companion.BASE_URL
import uk.co.harnick.bandkit.util.fetchApiResponse
import uk.co.harnick.bandkit.discovery.dto.fanfeed.FanFeedErrorDto
import uk.co.harnick.bandkit.discovery.dto.fanfeed.FanFeedRequest
import uk.co.harnick.bandkit.discovery.dto.fanfeed.FanFeedResponse

/**
 * Fetches a user's feed, including updates from followed artists.
 * @param userId The user ID for the target account.
 * @param olderThan The maximum timestamp for feed updates.
 * @return An instance of [FanFeedResponse].
 */
public suspend fun BandKit.fetchFanFeed(
    userId: Long,
    olderThan: Long = getTimeMillis()
): FanFeedResponse {
    val url = "$BASE_URL/fan_dash_feed_updates"

    // getTimeMillis is too accurate. We need to truncate to prevent a request error.
    val trimmedTimestamp = "$olderThan".slice(0..11).toLong()

    val requestBody = Json.encodeToString(
        FanFeedRequest(userId, trimmedTimestamp)
    )

    return fetchApiResponse<FanFeedResponse, FanFeedErrorDto>(url, HttpMethod.Get, requestBody)
}
