package uk.co.harnick.bandkit.discovery

import io.ktor.http.ContentType.Application.Json
import io.ktor.http.HttpMethod
import uk.co.harnick.bandkit.core.BandKit
import uk.co.harnick.bandkit.core.BandKit.Companion.BASE_URL
import uk.co.harnick.bandkit.core.dto.ApiError
import uk.co.harnick.bandkit.discovery.dto.AlbumOfTheDay
import uk.co.harnick.bandkit.util.fetchApiResponse

/**
 * Fetches the current album of the day.
 * @return An instance of [AlbumOfTheDay].
 */
public suspend fun BandKit.fetchAlbumOfTheDay(
): AlbumOfTheDay {
    val url = "$BASE_URL/api/homepage_api/1/get_aotd"

    return fetchApiResponse<AlbumOfTheDay, ApiError>(
        url = url,
        httpMethod = HttpMethod.Post,
        contentType = Json
    )
}
