package uk.co.harnick.bandkit.discovery

import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.HttpMethod.Companion.Post
import uk.co.harnick.bandkit.core.BandKit
import uk.co.harnick.bandkit.core.BandKit.Companion.BASE_URL
import uk.co.harnick.bandkit.util.fetchApiResponse
import uk.co.harnick.bandkit.discovery.dto.fanfeed.FanFeedError
import uk.co.harnick.bandkit.discovery.dto.fanfeed.FanFeedRequest
import uk.co.harnick.bandkit.discovery.dto.fanfeed.FanFeedResponse
import uk.co.harnick.bandkit.discovery.util.urlEncode
import kotlin.time.Clock
import kotlin.time.ExperimentalTime

/**
 * Fetches a user's feed, including updates from followed artists.
 * @param userId The user ID for the target account.
 * @param timestampCursor The upper bound for feed timestamps in seconds.
 * @return An instance of [FanFeedResponse].
 */
@OptIn(ExperimentalTime::class)
private suspend fun BandKit.fetchFanFeed(
    userId: Long,
    timestampCursor: Long = Clock.System.now().epochSeconds
): FanFeedResponse {
    val url = "$BASE_URL/fan_dash_feed_updates"

    val requestBody = urlEncode(
        FanFeedRequest(userId, timestampCursor)
    )

    return fetchApiResponse<FanFeedResponse, FanFeedError>(
        url = url,
        httpMethod = Post,
        contentType = ContentType.Application.FormUrlEncoded,
        config = { setBody(requestBody) }
    )
}
