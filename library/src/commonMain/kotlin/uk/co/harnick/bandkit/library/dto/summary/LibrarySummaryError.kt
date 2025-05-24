package uk.co.harnick.bandkit.library.dto.summary

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import uk.co.harnick.bandkit.core.dto.ApiError

@ConsistentCopyVisibility
@Serializable
internal data class LibrarySummaryError private constructor(
    @SerialName("error")
    val error: Boolean,
    @SerialName("error_message")
    val errorMessage: String
) : ApiError {
    override val message: String = when (errorMessage.isBlank()) {
        true -> "An unidentified error occurred when fetching library summary."
        false -> errorMessage
    }
}
