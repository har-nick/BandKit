package uk.co.harnick.bandkit.data.remote.dto.follower

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Suppress("UNUSED")
@Serializable
internal class FollowersResponseDto(
    // Yes, this is actually a misspelling.
    @SerialName("followeers")
    val followers: List<FollowerDto>,
    @SerialName("more_available")
    val moreAvailable: Boolean,
    @SerialName("last_token")
    val lastToken: String
)
