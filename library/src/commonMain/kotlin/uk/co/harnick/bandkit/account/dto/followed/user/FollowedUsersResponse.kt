package uk.co.harnick.bandkit.account.dto.followed.user

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The API response for [fetchFollowedUsers][uk.co.harnick.bandkit.account.fetchFollowedUsers].
 * @property followed The list of followed users by the account.
 * @property moreUsersAvailable true if [followed] does not contain all the followed users.
 * @property paginationToken Unsure of this purpose. TO BE DOCUMENTED FURTHER.
 */
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
