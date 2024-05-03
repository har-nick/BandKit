package uk.co.harnick.bandkit.data.remote.dto.followee.band

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Suppress("UNUSED")
@Serializable
internal class ArtistFolloweeDto(
    @SerialName("band_id")
    val artistId: Long,
    @SerialName("art_id")
    val avatarId: Long?,
    @SerialName("date_followed")
    val dateFollowed: String,
    @SerialName("image_id")
    val imageId: Long?,
    @SerialName("is_following")
    val isFollowing: Boolean,
    @SerialName("is_subscribed")
    val isSubscribed: Boolean?,
    val location: String?,
    val nickname: String,
    val token: String,
    @SerialName("url_hints")
    val urlHints: UrlHintsDto
)
