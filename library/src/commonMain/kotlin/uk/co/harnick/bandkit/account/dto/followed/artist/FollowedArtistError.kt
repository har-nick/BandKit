package uk.co.harnick.bandkit.account.dto.followed.artist

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import uk.co.harnick.bandkit.core.dto.ApiError

@Serializable
internal class FollowedArtistError internal constructor(
    @SerialName("error")
    val error: Boolean,
    @SerialName("error_message")
    val errorMessage: String
) : ApiError {
    override val message: String = when (errorMessage.isBlank()) {
        true -> "An unidentified error occurred when fetching followed artists."
        false -> errorMessage
    }
}
