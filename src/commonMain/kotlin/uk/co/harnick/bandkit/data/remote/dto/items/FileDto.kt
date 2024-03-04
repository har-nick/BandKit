package uk.co.harnick.bandkit.data.remote.dto.items


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public class FileDto(
    @SerialName("mp3-v0")
    public val mp3V0: String
)
