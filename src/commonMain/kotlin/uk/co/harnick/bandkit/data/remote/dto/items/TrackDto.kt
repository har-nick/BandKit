package uk.co.harnick.bandkit.data.remote.dto.items

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal class TrackDto(
    val id: Long,
    val title: String,
    val artist: String,
    @SerialName("track_number")
    val trackNumber: Int,
    val duration: Double,
    @SerialName("file")
    val adaptiveStreamUrl: String
)
