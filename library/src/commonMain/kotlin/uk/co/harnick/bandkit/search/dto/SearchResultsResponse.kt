package uk.co.harnick.bandkit.search.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public class SearchResultsResponse internal constructor(
    @SerialName("auto")
    public val searchResults: SearchResults,

    @SerialName("tag")
    public val tagResults: TagResults,

    @SerialName("genre")
    public val genreResult: GenreResults
)
