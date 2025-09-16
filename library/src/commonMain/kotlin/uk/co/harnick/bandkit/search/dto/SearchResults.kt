package uk.co.harnick.bandkit.search.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public class SearchResults internal constructor(
    @SerialName("results")
    public val items: List<SearchResult>,

    @SerialName("stat_params_for_tag")
    public val statParamsForTag: String,

    @SerialName("time_ms")
    public val timeMs: Long
)
