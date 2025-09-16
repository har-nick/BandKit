package uk.co.harnick.bandkit.account.dto.followed.artist

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

/**
 * An instance of a followed artist.
 * @property artistId The artist's ID.
 * @property avatarId The artist's avatar ID.
 * @property bannerId The artist's banner ID.
 * @property urlHints The artist's Bandcamp URL data.
 * @property displayName The artist's display name.
 * @property userIsFollowing true if the target account follows the artist.
 * @property userIsSubscribed true if the target account subscribes to the artist.
 * @property location Always null.
 * @property dateFollowed The date the target account followed the artist in RFC 1123 format.
 * @property lastToken The last token for the followed account, in the format [dateFollowed]:[artistId], with [dateFollowed] being a unix timestamp.
 */
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
    public val lastToken: String
)
