package uk.co.harnick.bandkit.account.dto.followed.artist

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import uk.co.harnick.bandkit.library.dto.item.UrlHints

@Serializable
public class FollowedArtist private constructor(
    @SerialName("band_id")
    public val artistId: Long,

    @SerialName("image_id")
    public val avatarId: Long,

    @SerialName("art_id")
    public val bannerId: Long,

    @SerialName("url_hints")
    public val urlHints: UrlHints,

    @SerialName("name")
    public val displayName: String,

    // MORE INFO NEEDED:    Seems redundant?
    @SerialName("is_following")
    public val userIsFollowing: Boolean,

    @SerialName("is_subscribed")
    public val userIsSubscribed: Boolean,

    @SerialName("location")
    public val location: String?,

    @SerialName("date_followed")
    public val dateFollowed: String,

    @SerialName("token")
    public val paginationToken: String
)
