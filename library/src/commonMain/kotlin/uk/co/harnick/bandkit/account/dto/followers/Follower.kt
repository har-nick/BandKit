package uk.co.harnick.bandkit.account.dto.followers

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * An instance of a following user.
 * @property userId The user's ID.
 * @property artistId The user's artist ID, if one exists.
 * @property fanUrl Always null.
 * @property avatarId The user's avatar ID, if one exists.
 * @property url The user's Bandcamp URL.
 * @property displayName The user's display name.
 * @property isMutual true if the followed user also follows the target account.
 * @property location The user's location.
 * @property dateFollowed The date the target account followed the user in RFC 1123 format.
 * @property paginationToken The last token for the followed account, in the format [dateFollowed]:[userId], with [dateFollowed] being a unix timestamp.
 */
@Serializable
public class Follower internal constructor(
    @SerialName("fan_id")
    public val userId: Long,

    @SerialName("band_id")
    public val artistId: Long?,

    // MORE INFO NEEDED:    Unsure how this differs to `trackpipe_url`.
    //                      Seems to be null across all accounts?
    @SerialName("fan_url")
    public val fanUrl: String?,

    @SerialName("image_id")
    public val avatarId: Long?,

    @SerialName("trackpipe_url")
    public val url: String,

    @SerialName("name")
    public val displayName: String?,

    @SerialName("is_following")
    public val isMutual: Boolean,

    @SerialName("location")
    public val location: String?,

    @SerialName("date_followed")
    public val dateFollowed: String,

    @SerialName("token")
    public val paginationToken: String
)
