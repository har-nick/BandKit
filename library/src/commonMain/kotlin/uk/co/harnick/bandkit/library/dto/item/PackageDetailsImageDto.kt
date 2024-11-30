package uk.co.harnick.bandkit.library.dto.item

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal class PackageDetailsImageDto private constructor(
    @SerialName("image_id")
    val id: Long,

    @SerialName("width")
    val width: Int,

    @SerialName("height")
    val height: Int
)
