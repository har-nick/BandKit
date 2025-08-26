package uk.co.harnick.bandkit.search

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
