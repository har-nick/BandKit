package uk.co.harnick.bandkit.data.remote.dto.followee.fan

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Suppress("UNUSED")
@Serializable
internal class FanFolloweeDto(
    @SerialName("image_id")
    val avatarId: Long?,
    @SerialName("band_id")
    val bandId: Long?,
    @SerialName("date_followed")
    val dateFollowed: String,
    @SerialName("fan_id")
    val fanId: Long,
    @SerialName("fan_url")
    val fanUrl: String?,
    @SerialName("is_following")
    val isFollowing: Boolean,
    @SerialName("name")
    val location: String?,
    val nickname: String,
    val token: String,
    @SerialName("trackpipe_url")
    val url: String
)
