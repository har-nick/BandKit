package uk.co.harnick.bandkit.account.dto.followed.user

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public class FollowedUser internal constructor(
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
    public val displayName: String,

    @SerialName("is_following")
    public val isMutual: Boolean,

    @SerialName("location")
    public val location: String?,

    @SerialName("date_followed")
    public val dateFollowed: String,

    @SerialName("token")
    public val paginationToken: String
)
