package uk.co.harnick.bandkit.library

import io.ktor.http.HttpMethod
import io.ktor.util.date.getTimeMillis
import kotlinx.serialization.json.Json
import uk.co.harnick.bandkit.core.BandKit
import uk.co.harnick.bandkit.core.BandKit.Companion.BASE_URL
import uk.co.harnick.bandkit.core.getApiResponse
import uk.co.harnick.bandkit.library.dto.item.LibraryItemRequest
import uk.co.harnick.bandkit.library.dto.item.LibraryItemsError
import uk.co.harnick.bandkit.library.dto.item.LibraryItemsResponse

public suspend fun BandKit.fetchLibraryItems(
    userId: Long,
    itemLimit: Int = Int.MAX_VALUE,
    upperBoundTimestamp: Long = getTimeMillis()
): LibraryItemsResponse {
    val url = "$BASE_URL/api/fancollection/1/collection_items"

    // getTimeMillis is too accurate. We need to truncate to prevent a request error.
    val trimmedTimestamp = "$upperBoundTimestamp".slice(0..11)

    val requestBody = Json.encodeToString(
        LibraryItemRequest(userId, "$trimmedTimestamp::a::", itemLimit)
    )

    return getApiResponse<LibraryItemsResponse, LibraryItemsError>(
        url = url,
        httpMethod = HttpMethod.Post,
        body = requestBody
    )
}
