package uk.co.harnick.bandkit.search.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class SearchResultsRequest internal constructor(
    @SerialName("search_text")
    val searchText: String,

    @SerialName("search_filter")
    val searchFilter: String,

    @SerialName("full_page")
    val fullPage: Boolean,

    @SerialName("fan_id")
    val fanId: Long?
)
