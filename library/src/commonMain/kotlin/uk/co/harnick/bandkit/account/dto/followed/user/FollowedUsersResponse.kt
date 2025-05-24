package uk.co.harnick.bandkit.account.dto.followed.user

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import uk.co.harnick.bandkit.account.dto.followed.artist.FollowedArtist

@Serializable
public class FollowedUsersResponse private constructor(
    // NOTE:    sic.
    @SerialName("followeers")
    public val followers: List<FollowedArtist>,

    @SerialName("more_available")
    public val moreFollowersAvailable: Boolean,

    @SerialName("last_token")
    public val paginationToken: String
)
