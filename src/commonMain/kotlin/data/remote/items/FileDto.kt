package data.remote.items

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FileDto(
    @SerialName("mp3-v0")
    val mp3V0: String
)
