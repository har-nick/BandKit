package uk.co.harnick.bandkit.data.remote.dto.items

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Suppress("UNUSED")
@Serializable
internal class ImageDto(
    @SerialName("image_id")
    val imageId: Long,
    val width: Int,
    val height: Int
)
