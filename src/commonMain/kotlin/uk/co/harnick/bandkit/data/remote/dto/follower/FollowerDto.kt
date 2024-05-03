package uk.co.harnick.bandkit.data.remote.dto.follower

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Suppress("UNUSED")
@Serializable
internal class FollowerDto(
    @SerialName("fan_id")
    val fanId: Long?,
    @SerialName("band_id")
    val artistId: Long?,
    @SerialName("fan_url")
    val fanUrl: String?,
    @SerialName("image_id")
    val avatarId: Long?,
    @SerialName("trackpipe_url")
    val url: String,
    @SerialName("name")
    val displayName: String,
    @SerialName("is_following")
    val isFollowed: Boolean,
    val location: String,
    @SerialName("date_followed")
    val dateFollowed: String,
    val token: String
)
