package uk.co.harnick.bandkit.library

import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.HttpMethod
import io.ktor.util.date.getTimeMillis
import kotlinx.serialization.json.Json
import uk.co.harnick.bandkit.core.BandKit
import uk.co.harnick.bandkit.core.BandKit.Companion.BASE_URL
import uk.co.harnick.bandkit.core.BandKitException.MissingTokenException
import uk.co.harnick.bandkit.util.fetchApiResponse
import uk.co.harnick.bandkit.library.dto.item.LibraryItemRequest
import uk.co.harnick.bandkit.library.dto.item.LibraryItemsError
import uk.co.harnick.bandkit.library.dto.item.owned.OwnedLibraryItemsResponse
import uk.co.harnick.bandkit.library.dto.item.public.PublicLibraryItemsResponse

private suspend inline fun <reified T> BandKit.fetchLibraryItems(
    userId: Long,
    token: String?,
    itemLimit: Int = Int.MAX_VALUE,
    timestampCursor: Long = getTimeMillis() / 1000
): T {
    val url = "$BASE_URL/api/fancollection/1/collection_items"

    val requestBody = Json.encodeToString(
        LibraryItemRequest(userId, "$timestampCursor::a::", itemLimit)
    )

    return fetchApiResponse<T, LibraryItemsError>(
        url = url,
        httpMethod = HttpMethod.Post,
        token = token,
        contentType = ContentType.Application.Json,
        config = { setBody(requestBody) }
    )
}

/**
 * Fetches an account's private library data.
 * @param userId The library's owner.
 * @param token The token for the owning account.
 * @param itemLimit The maximum number of library items to fetch.
 * @param timestampCursor The upper bound for the timestamp of each purchased item.
 * @return An instance of [OwnedLibraryItemsResponse].
 */
public suspend fun BandKit.fetchPrivateLibraryData(
    userId: Long,
    token: String? = this.decodedToken ?: throw MissingTokenException(),
    itemLimit: Int = Int.MAX_VALUE,
    timestampCursor: Long = getTimeMillis() / 1000
): OwnedLibraryItemsResponse =
    fetchLibraryItems<OwnedLibraryItemsResponse>(userId, token, itemLimit, timestampCursor)

/**
 * Fetches an account's public library data.
 * @param userId The library's owner.
 * @param itemLimit The maximum number of library items to fetch.
 * @param timestampCursor Unsure of this purpose. TO BE DOCUMENTED FURTHER.
 * @return An instance of [OwnedLibraryItemsResponse].
 */
public suspend fun BandKit.fetchPublicLibraryItems(
    userId: Long,
    itemLimit: Int = Int.MAX_VALUE,
    timestampCursor: Long = getTimeMillis() / 1000
): PublicLibraryItemsResponse =
    fetchLibraryItems<PublicLibraryItemsResponse>(userId, null, itemLimit, timestampCursor)
