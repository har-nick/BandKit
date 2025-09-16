package uk.co.harnick.bandkit.search.dto

import kotlinx.serialization.Serializable
import uk.co.harnick.bandkit.search.util.SearchResultSerializer

@Serializable(with = SearchResultSerializer::class)
public sealed interface SearchResult
