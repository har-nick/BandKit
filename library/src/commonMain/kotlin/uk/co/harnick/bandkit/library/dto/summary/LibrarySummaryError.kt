package uk.co.harnick.bandkit.library.dto.summary

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import uk.co.harnick.bandkit.core.dto.ApiError

@ConsistentCopyVisibility
@Serializable
internal data class LibrarySummaryError internal constructor(
    @SerialName("error")
    val error: Boolean,
    @SerialName("error_message")
    val errorMessage: String
) : ApiError {
    override val message: String = when (errorMessage) {
        "" -> "An unidentified error occurred when fetching library summary."
        "must be logged in" -> "Account token is invalid."
        else -> errorMessage
    }
}
