package uk.co.harnick.bandkit.account.dto.followed.user

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public class FollowedUsersResponse internal constructor(
    // NOTE:    sic.
    @SerialName("followeers")
    public val followed: List<FollowedUser>,

    @SerialName("more_available")
    public val moreUsersAvailable: Boolean,

    @SerialName("last_token")
    public val paginationToken: String
)
