package uk.co.harnick.bandkit.data.remote.dto.items

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public class TrackDto(
    public val id: Long,
    public val title: String,
    public val artist: String,
    @SerialName("track_number")
    public val trackNumber: Int?,
    public val duration: Float,
    @SerialName("file")
    public val adaptiveStreamUrl: Map<String, String>
)
