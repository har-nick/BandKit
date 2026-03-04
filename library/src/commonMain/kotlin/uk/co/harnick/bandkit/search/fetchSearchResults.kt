package uk.co.harnick.bandkit.search

import io.ktor.client.request.setBody
import io.ktor.http.ContentType.Application.Json
import io.ktor.http.HttpMethod.Companion.Post
import kotlinx.serialization.json.Json as JsonSerializer
import uk.co.harnick.bandkit.core.BandKit
import uk.co.harnick.bandkit.core.BandKit.Companion.BASE_URL
import uk.co.harnick.bandkit.core.BandKit.SearchFilter
import uk.co.harnick.bandkit.search.dto.SearchResultsError
import uk.co.harnick.bandkit.search.dto.SearchResultsRequest
import uk.co.harnick.bandkit.search.dto.SearchResultsResponse
import uk.co.harnick.bandkit.util.fetchApiResponse

public suspend fun BandKit.fetchSearchResults(
    searchValue: String,
    filter: SearchFilter = SearchFilter.None
): SearchResultsResponse {
    val url = "$BASE_URL/api/bcsearch_public_api/1/autocomplete_elastic"

    val requestBody = JsonSerializer.encodeToString(
        SearchResultsRequest(
            searchText = searchValue,
            searchFilter = filter.apiRef,
            // NOTE: Makes no change to result data, AFAIK.
            fullPage = false,
            // TODO: Is fanId origin of search, or target/filter?
            fanId = null
        )
    )

    return fetchApiResponse<SearchResultsResponse, SearchResultsError>(
        url = url,
        httpMethod = Post,
        contentType = Json,
        config = { setBody(requestBody) }
    )
}
