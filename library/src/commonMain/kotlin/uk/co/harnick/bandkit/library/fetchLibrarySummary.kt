package uk.co.harnick.bandkit.library

import io.ktor.client.call.body
import io.ktor.client.request.accept
import io.ktor.client.request.get
import io.ktor.client.request.url
import io.ktor.http.ContentType
import io.ktor.http.contentType
import uk.co.harnick.bandkit.core.BandKit
import uk.co.harnick.bandkit.library.dto.summary.LibrarySummaryResponseDto

public suspend fun BandKit.fetchLibrarySummary(): LibrarySummaryResponseDto {
    val response = client.get {
        url(BandKit.Library.SUMMARY)
        contentType(ContentType.Application.Json)
        accept(ContentType.Application.Json)
    }

    return response.body<LibrarySummaryResponseDto>()
}
