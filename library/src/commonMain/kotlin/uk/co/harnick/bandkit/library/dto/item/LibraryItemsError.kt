package uk.co.harnick.bandkit.library.dto.item

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import uk.co.harnick.bandkit.core.dto.ApiError

@Serializable
internal data class LibraryItemsError private constructor(
    @SerialName("error")
    val error: Boolean
) : ApiError {
    override val message: String = "An unidentified error occurred when fetching library items."
}
