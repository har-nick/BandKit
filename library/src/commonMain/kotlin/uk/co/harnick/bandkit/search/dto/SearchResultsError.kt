package uk.co.harnick.bandkit.search.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import uk.co.harnick.bandkit.core.dto.ApiError

@Serializable
internal class SearchResultsError internal constructor(
    @SerialName("__api_special__")
    val apiSpecial: String,

    @SerialName("error_type")
    val errorType: String
) : ApiError {
    override val message: String = when (apiSpecial.isBlank()) {
        true -> "An unidentified error occurred when fetching search results."
        false -> apiSpecial
    }
}
