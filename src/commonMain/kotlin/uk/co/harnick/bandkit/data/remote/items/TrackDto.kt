package uk.co.harnick.bandkit.data.remote.items

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TrackDto(
    @SerialName("id")
    val id: Long,
    @SerialName("title")
    val title: String,
    @SerialName("artist")
    val artist: String,
    @SerialName("trackNumber")
    val trackNumber: Int,
    @SerialName("duration")
    val duration: Float,
    @SerialName("file")
    val streamUrl: Map<String, String>
)
