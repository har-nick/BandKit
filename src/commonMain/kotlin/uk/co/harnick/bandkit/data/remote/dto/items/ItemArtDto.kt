package uk.co.harnick.bandkit.data.remote.dto.items

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Suppress("UNUSED")
@Serializable
internal class ItemArtDto(
    val url: String,
    @SerialName("thumb_url")
    val thumbUrl: String,
    @SerialName("art_id")
    val artId: Long
)
