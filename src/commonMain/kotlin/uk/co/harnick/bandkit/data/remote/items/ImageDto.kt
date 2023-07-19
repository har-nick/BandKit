package uk.co.harnick.bandkit.data.remote.items

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ImageDto(
    @SerialName("height")
    val height: Int,
    @SerialName("image_id")
    val imageId: Int,
    @SerialName("width")
    val width: Int
)
