package uk.co.harnick.bandkit.library

import io.ktor.http.HttpMethod
import uk.co.harnick.bandkit.core.BandKit
import uk.co.harnick.bandkit.core.BandKit.Companion.BASE_URL
import uk.co.harnick.bandkit.core.getApiResponse
import uk.co.harnick.bandkit.library.dto.summary.LibrarySummaryError
import uk.co.harnick.bandkit.library.dto.summary.LibrarySummaryResponse

public suspend fun BandKit.fetchLibrarySummary(): LibrarySummaryResponse {
    val url = "$BASE_URL/api/fan/2/collection_summary"

    return getApiResponse<LibrarySummaryResponse, LibrarySummaryError>(url, HttpMethod.Get)
}
