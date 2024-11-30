package uk.co.harnick.bandkit.account.dto.followed.user

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import uk.co.harnick.bandkit.account.dto.followed.artist.FollowedArtistDto

@Serializable
public class FollowedUsersResponseDto private constructor(
    // NOTE:    sic.
    @SerialName("followeers")
    public val followers: List<FollowedArtistDto>,

    @SerialName("more_available")
    public val moreFollowersAvailable: Boolean,

    @SerialName("last_token")
    public val paginationToken: String
)
