package uk.co.harnick.bandkit.account

import io.ktor.http.HttpMethod
import io.ktor.util.date.getTimeMillis
import kotlinx.serialization.json.Json
import uk.co.harnick.bandkit.account.dto.followers.FollowersError
import uk.co.harnick.bandkit.account.dto.followers.FollowersRequest
import uk.co.harnick.bandkit.account.dto.followers.FollowersResponse
import uk.co.harnick.bandkit.core.BandKit
import uk.co.harnick.bandkit.core.BandKit.Companion.BASE_URL
import uk.co.harnick.bandkit.core.getApiResponse

public suspend fun BandKit.fetchFollowers(
    userId: Long,
    accountLimit: Int = Int.MAX_VALUE,
    timestampCursor: Long = getTimeMillis(),
    userIdCursor: Long? = null
): FollowersResponse {
    val url = "$BASE_URL/api/fancollection/1/followers"

    // getTimeMillis is too accurate. We need to truncate to prevent a request error.
    val trimmedTimestamp = "$timestampCursor".slice(0..11).toLong()

    val paginationToken = buildString {
        append(trimmedTimestamp)
        append(userIdCursor ?: "::a::")
    }

    val requestBody = Json.encodeToString(
        FollowersRequest(userId, paginationToken, accountLimit)
    )

    return getApiResponse<FollowersResponse, FollowersError>(
        url = url,
        httpMethod = HttpMethod.Post,
        body = requestBody
    )
}
