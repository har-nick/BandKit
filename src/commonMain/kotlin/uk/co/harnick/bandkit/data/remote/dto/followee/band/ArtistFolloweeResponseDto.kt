package uk.co.harnick.bandkit.data.remote.dto.followee.band

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Suppress("UNUSED")
@Serializable
internal class ArtistFolloweeResponseDto(
    @SerialName("followeers")
    val followees: List<ArtistFolloweeDto>,
    @SerialName("more_available")
    val moreAvailable: Boolean,
    @SerialName("last_token")
    val lastToken: String
)
