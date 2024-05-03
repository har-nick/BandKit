package uk.co.harnick.bandkit.data.remote.dto.followee.fan

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Suppress("UNUSED")
@Serializable
internal class FanFolloweeResponseDto(
    @SerialName("followeers")
    val followees: List<FanFolloweeDto>,
    @SerialName("more_available")
    val moreAvailable: Boolean,
    @SerialName("last_token")
    val lastToken: String
)
