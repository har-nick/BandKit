package uk.co.harnick.bandkit.account.dto.followers

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The API response for [fetchFollowedUsers][uk.co.harnick.bandkit.account.fetchFollowers].
 * @property followers The list of users following the account.
 * @property moreFollowersAvailable true if [followers] does not contain all the following users.
 * @property paginationToken Unsure of this purpose. TO BE DOCUMENTED FURTHER.
 */
@Serializable
public class FollowersResponse internal constructor(
    // NOTE:    sic.
    @SerialName("followeers")
    public val followers: List<Follower>,

    @SerialName("more_available")
    public val moreFollowersAvailable: Boolean,

    @SerialName("last_token")
    public val paginationToken: String
)
