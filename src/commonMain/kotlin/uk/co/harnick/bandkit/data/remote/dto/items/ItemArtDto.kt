package uk.co.harnick.bandkit.data.remote.dto.items


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public class ItemArtDto(
    public val url: String,
    @SerialName("thumb_url")
    public val thumbUrl: String,
    @SerialName("art_id")
    public val artId: Long
)
