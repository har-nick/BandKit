package uk.co.harnick.bandkit.account

import io.ktor.client.call.body
import io.ktor.client.request.accept
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.util.date.getTimeMillis
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import uk.co.harnick.bandkit.account.dto.followed.artist.FollowedArtistsResponseDto
import uk.co.harnick.bandkit.account.dto.followers.FollowersRequestDto
import uk.co.harnick.bandkit.core.BandKit

public suspend fun BandKit.fetchFollowedArtists(
    userId: Long,
    accountLimit: Int = Int.MAX_VALUE,
    timestampCursor: Long = getTimeMillis(),
    userIdCursor: Long? = null
): FollowedArtistsResponseDto {
    val paginationToken = buildString {
        append(timestampCursor)
        append(userIdCursor ?: "::a::")
    }

    val reqBody = Json.encodeToString(
        FollowersRequestDto(userId, accountLimit, paginationToken)
    )

    val response = client.post {
        url(BandKit.Account.FOLLOWING_ARTISTS)
        contentType(ContentType.Application.Json)
        accept(ContentType.Application.Json)
        setBody(reqBody)
    }

    return response.body<FollowedArtistsResponseDto>()
}
