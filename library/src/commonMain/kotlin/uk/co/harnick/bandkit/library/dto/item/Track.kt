package uk.co.harnick.bandkit.library.dto.item

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public class Track private constructor(
    @SerialName("id")
    public val id: Long,

    @SerialName("title")
    public val title: String,

    @SerialName("artist")
    public val artist: String,

    @SerialName("track_number")
    public val index: Int?,

    @SerialName("duration")
    public val duration: Float,

    @SerialName("file")
    public val streamUrl: Map<String, String>,
)
