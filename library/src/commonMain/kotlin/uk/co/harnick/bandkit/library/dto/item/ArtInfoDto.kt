package uk.co.harnick.bandkit.library.dto.item

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public class ArtInfoDto private constructor(
    @SerialName("url")
    public val url: String,

    @SerialName("thumb_url")
    public val thumbnailUrl: String,

    @SerialName("art_id")
    public val artId: String
)
