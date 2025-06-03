package uk.co.harnick.bandkit.account.dto.followed.artist

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
public class FollowedArtist internal constructor(
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

    @SerialName("is_following")
    public val userIsFollowing: Boolean,

    // MORE INFO NEEDED:    Assuming this is a boolean, but missing data to be sure.
    @SerialName("is_subscribed")
    public val userIsSubscribed: JsonElement,

    @SerialName("location")
    public val location: String?,

    @SerialName("date_followed")
    public val dateFollowed: String,

    @SerialName("token")
    public val paginationToken: String
)
