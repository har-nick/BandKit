package uk.co.harnick.bandkit.discovery.dto.fanfeed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public class Thumbnail internal constructor(
    @SerialName("fan_id")
    public val fanId: Long,

    @SerialName("featured_track_id")
    public val featuredTrackId: Long?,

    @SerialName("username")
    public val username: String,

    @SerialName("name")
    public val displayName: String,

    @SerialName("url")
    public val fanUrl: String,

    @SerialName("why")
    public val review: String?,

    @SerialName("item_type")
    public val itemType: String,

    @SerialName("mod_date")
    public val collectionDate: String,

    @SerialName("image_id")
    public val fanAvatarId: Long,

    @SerialName("is_montage_image")
    public val isMontageImage: Boolean,

    @SerialName("token")
    public val token: String,

    @SerialName("fav_track_title")
    public val featuredTrackTitle: String
)
