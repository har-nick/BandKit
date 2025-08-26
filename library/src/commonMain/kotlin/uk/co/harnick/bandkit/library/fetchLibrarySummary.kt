package uk.co.harnick.bandkit.library

import io.ktor.http.HttpMethod.Companion.Get
import uk.co.harnick.bandkit.core.BandKit
import uk.co.harnick.bandkit.core.BandKit.Companion.BASE_URL
import uk.co.harnick.bandkit.core.BandKitException.MissingTokenException
import uk.co.harnick.bandkit.util.fetchApiResponse
import uk.co.harnick.bandkit.library.dto.summary.LibrarySummaryError
import uk.co.harnick.bandkit.library.dto.summary.LibrarySummaryResponse

public suspend fun BandKit.fetchLibrarySummary(
    token: String = this.decodedToken ?: throw MissingTokenException()
): LibrarySummaryResponse {
    val url = "$BASE_URL/api/fan/2/collection_summary"

    return fetchApiResponse<LibrarySummaryResponse, LibrarySummaryError>(
        url = url,
        httpMethod = Get,
        token = token
    )
}
