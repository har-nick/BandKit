package uk.co.harnick.bandkit.account

import io.ktor.http.HttpMethod.Companion.Post
import io.ktor.util.date.getTimeMillis
import kotlinx.serialization.json.Json
import uk.co.harnick.bandkit.account.dto.followed.artist.FollowedArtistError
import uk.co.harnick.bandkit.account.dto.followed.artist.FollowedArtistsResponse
import uk.co.harnick.bandkit.account.dto.followers.FollowersRequest
import uk.co.harnick.bandkit.core.BandKit
import uk.co.harnick.bandkit.core.BandKit.Companion.BASE_URL
import uk.co.harnick.bandkit.util.fetchApiResponse

public suspend fun BandKit.fetchFollowedArtists(
    userId: Long,
    accountLimit: Int = Int.MAX_VALUE,
    timestampCursor: Long = getTimeMillis(),
    userIdCursor: Long? = null
): FollowedArtistsResponse {
    val url = "$BASE_URL/api/fancollection/1/following_bands"

    // getTimeMillis is too accurate. We need to truncate to prevent a request error.
    val trimmedTimestamp = "$timestampCursor".slice(0..11).toLong()

    val paginationToken = buildString {
        append(trimmedTimestamp)
        append(userIdCursor ?: "::a::")
    }

    val requestBody = Json.encodeToString(
        FollowersRequest(userId, paginationToken, accountLimit)
    )

    return fetchApiResponse<FollowedArtistsResponse, FollowedArtistError>(
        url = url,
        httpMethod = Post,
        body = requestBody
    )
}
