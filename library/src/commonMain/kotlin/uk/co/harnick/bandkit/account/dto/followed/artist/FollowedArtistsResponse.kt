package uk.co.harnick.bandkit.account.dto.followed.artist

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The API response for [fetchFollowedArtists][uk.co.harnick.bandkit.account.fetchFollowedArtists].
 * @property followed The list of followed artists by the account.
 * @property moreFollowersAvailable true if [followed] does not contain all the followed artists.
 * @property paginationToken Unsure of this purpose. TO BE DOCUMENTED FURTHER.
 */
@Serializable
public class FollowedArtistsResponse internal constructor(
    // NOTE:    sic.
    @SerialName("followeers")
    public val followed: List<FollowedArtist>,

    @SerialName("more_available")
    public val moreFollowersAvailable: Boolean,

    @SerialName("last_token")
    public val paginationToken: String
)
