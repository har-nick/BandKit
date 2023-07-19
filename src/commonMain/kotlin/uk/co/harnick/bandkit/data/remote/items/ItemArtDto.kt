package uk.co.harnick.bandkit.data.remote.items

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ItemArtDto(
    @SerialName("art_id")
    val artId: Long,
    @SerialName("thumb_url")
    val thumbUrl: String,
    @SerialName("url")
    val url: String
)
