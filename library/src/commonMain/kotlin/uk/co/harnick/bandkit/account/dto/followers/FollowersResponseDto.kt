package uk.co.harnick.bandkit.account.dto.followers

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public class FollowersResponseDto private constructor(
    // NOTE:    sic.
    @SerialName("followeers")
    public val followers: List<FollowerDto>,

    @SerialName("more_available")
    public val moreFollowersAvailable: Boolean,

    @SerialName("last_token")
    public val paginationToken: String
)
