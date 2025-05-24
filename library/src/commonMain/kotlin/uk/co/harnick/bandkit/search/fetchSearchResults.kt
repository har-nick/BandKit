package uk.co.harnick.bandkit.search

import io.ktor.http.HttpMethod
import kotlinx.serialization.json.Json
import uk.co.harnick.bandkit.core.BandKit
import uk.co.harnick.bandkit.core.BandKit.Companion.BASE_URL
import uk.co.harnick.bandkit.core.BandKit.SearchFilter
import uk.co.harnick.bandkit.core.BandKit.SearchFilter.None
import uk.co.harnick.bandkit.core.getApiResponse
import uk.co.harnick.bandkit.search.dto.SearchResultsError
import uk.co.harnick.bandkit.search.dto.SearchResultsRequest

//public suspend fun BandKit.fetchSearchResults(
//    searchValue: String,
//    filter: SearchFilter = None
//): SearchResultsResponse {
//    val url = "$BASE_URL/api/bcsearch_public_api/1/autocomplete_elastic"
//
//    val requestBody = Json.encodeToString(
//        SearchResultsRequest(
//            searchText = searchValue,
//            searchFilter = filter.apiRef,
//            // NOTE: Makes no change to result data, AFAIK.
//            fullPage = false,
//            // TODO: Is fanId origin of search, or target/filter?
//            fanId = null
//        )
//    )
//
//    return getApiResponse<SearchResultsResponse, SearchResultsError>(
//        url = url,
//        httpMethod = HttpMethod.Post,
//        body = requestBody
//    )
//}
