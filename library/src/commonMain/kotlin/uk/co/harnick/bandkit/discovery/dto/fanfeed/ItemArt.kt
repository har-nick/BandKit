package uk.co.harnick.bandkit.discovery.dto.fanfeed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public class ItemArt internal constructor(
    @SerialName("url")
    public val url: String,

    @SerialName("thumb_url")
    public val thumbnailUrl: String,

    @SerialName("art_id")
    public val artId: Long
)
