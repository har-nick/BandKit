package uk.co.harnick.bandkit.account.dto.followed.user

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import uk.co.harnick.bandkit.core.dto.ApiError

@Serializable
internal data class FollowedUserError internal constructor(
    @SerialName("error")
    val error: Boolean,
    @SerialName("error_message")
    val errorMessage: String
) : ApiError {
    override val message: String = when (errorMessage.isBlank()) {
        true -> "An unidentified error occurred when fetching followed users."
        false -> errorMessage
    }
}
