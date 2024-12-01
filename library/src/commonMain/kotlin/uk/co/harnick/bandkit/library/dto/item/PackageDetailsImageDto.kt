package uk.co.harnick.bandkit.library.dto.item

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public class PackageDetailsImageDto private constructor(
    @SerialName("image_id")
    public val id: Long,

    @SerialName("width")
    public val width: Int,

    @SerialName("height")
    public val height: Int
)
