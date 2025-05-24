package uk.co.harnick.bandkit.search.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class SearchResultsError private constructor(
    @SerialName("__api_special__")
    val apiSpecial: String,

    @SerialName("error_type")
    val errorType: String
)
