package uk.co.harnick.bandkit.account

import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.HttpMethod.Companion.Post
import io.ktor.util.date.getTimeMillis
import kotlinx.serialization.json.Json
import uk.co.harnick.bandkit.account.dto.followers.FollowersError
import uk.co.harnick.bandkit.account.dto.followers.FollowersRequest
import uk.co.harnick.bandkit.account.dto.followers.FollowersResponse
import uk.co.harnick.bandkit.core.BandKit
import uk.co.harnick.bandkit.core.BandKit.Companion.BASE_URL
import uk.co.harnick.bandkit.util.fetchApiResponse

/**
 * Fetches all accounts following an account.
 * @param userId The user ID for the target account.
 * @param accountLimit The maximum number of following accounts to fetch.
 * @param timestampCursor Unsure of this purpose. TO BE DOCUMENTED FURTHER.
 * @param userIdCursor A cursor given by the previously fetched results.
 * @return An instance of [FollowersResponse].
 */
public suspend fun BandKit.fetchFollowers(
    userId: Long,
    accountLimit: Int = Int.MAX_VALUE,
    timestampCursor: Long = getTimeMillis(),
    userIdCursor: Long? = null
): FollowersResponse {
    val url = "$BASE_URL/api/fancollection/1/followers"

    // getTimeMillis is too accurate. We need to truncate to prevent a request error.
    val trimmedTimestamp = "$timestampCursor".take(12).toLong()

    val paginationToken = buildString {
        append(trimmedTimestamp)
        append(userIdCursor ?: "::a::")
    }

    val requestBody = Json.encodeToString(
        FollowersRequest(userId, paginationToken, accountLimit)
    )

    return fetchApiResponse<FollowersResponse, FollowersError>(
        url = url,
        httpMethod = Post,
        contentType = ContentType.Application.Json,
        config = { setBody(requestBody) }
    )
}
