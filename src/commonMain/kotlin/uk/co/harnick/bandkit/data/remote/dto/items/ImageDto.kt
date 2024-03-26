package uk.co.harnick.bandkit.data.remote.dto.items

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public class ImageDto(
    @SerialName("image_id")
    public val imageId: Int,
    public val width: Int,
    public val height: Int
)
