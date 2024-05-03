package uk.co.harnick.bandkit.data.remote.dto.items

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal class TrackDto(
    val id: Long,
    val title: String,
    val artist: String,
    @SerialName("track_number")
    val index: Int?,
    val duration: Float,
    @SerialName("file")
    val adaptiveStreamUrl: Map<String, String>
)
