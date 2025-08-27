package uk.co.harnick.bandkit.account

import io.ktor.http.HttpMethod
import io.ktor.util.date.getTimeMillis
import kotlinx.serialization.json.Json
import uk.co.harnick.bandkit.account.dto.followed.user.FollowedUserError
import uk.co.harnick.bandkit.account.dto.followed.user.FollowedUserRequest
import uk.co.harnick.bandkit.account.dto.followed.user.FollowedUsersResponse
import uk.co.harnick.bandkit.core.BandKit
import uk.co.harnick.bandkit.core.BandKit.Companion.BASE_URL
import uk.co.harnick.bandkit.util.fetchApiResponse

/**
 * Fetches users followed by an account.
 * @param userId The user ID for the target account.
 * @param accountLimit The maximum number of followed users to fetch.
 * @param timestampCursor Unsure of this purpose. TO BE DOCUMENTED FURTHER.
 * @param userIdCursor A cursor given by the previously fetched results.
 * @return An instance of [FollowedUsersResponse].
 */
public suspend fun BandKit.fetchFollowedUsers(
    userId: Long,
    accountLimit: Int = Int.MAX_VALUE,
    timestampCursor: Long = getTimeMillis(),
    userIdCursor: Long? = null
): FollowedUsersResponse {
    val url = "$BASE_URL/api/fancollection/1/following_fans"

    // getTimeMillis is too accurate. We need to truncate to prevent a request error.
    val trimmedTimestamp = "$timestampCursor".slice(0..11).toLong()

    val paginationToken = buildString {
        append(trimmedTimestamp)
        append(userIdCursor ?: "::a::")
    }

    val requestBody = Json.encodeToString(
        FollowedUserRequest(userId, accountLimit, paginationToken)
    )

    return fetchApiResponse<FollowedUsersResponse, FollowedUserError>(
        url = url,
        httpMethod = HttpMethod.Post,
        body = requestBody
    )
}
