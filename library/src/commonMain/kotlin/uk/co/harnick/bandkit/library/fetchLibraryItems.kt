package uk.co.harnick.bandkit.library

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
import uk.co.harnick.bandkit.core.BandKit
import uk.co.harnick.bandkit.library.dto.item.LibraryItemRequestDto
import uk.co.harnick.bandkit.library.dto.item.LibraryItemsResponseDto

public suspend fun BandKit.fetchLibraryItems(
    userId: Long,
    itemLimit: Int = Int.MAX_VALUE,
    timestampCursor: Long = getTimeMillis()
): LibraryItemsResponseDto {
    val reqBody = Json.encodeToString(
        LibraryItemRequestDto(userId, itemLimit, "$timestampCursor::a::")
    )

    val response = client.post {
        url(BandKit.Library.SUMMARY)
        contentType(ContentType.Application.Json)
        accept(ContentType.Application.Json)
        setBody(reqBody)
    }

    return response.body<LibraryItemsResponseDto>()
}
