package uk.co.harnick.bandkit.data.remote.dto.items

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal class FileDto(
    @SerialName("mp3-v0")
    val mp3V0: String
)