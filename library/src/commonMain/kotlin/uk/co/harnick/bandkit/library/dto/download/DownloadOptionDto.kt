package uk.co.harnick.bandkit.library.dto.download

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public class DownloadOptionDto internal constructor(
    @SerialName("size_mb")
    public val size: Float,

    @SerialName("description")
    public val description: String,

    @SerialName("encoding_name")
    public val encoding: String,

    @SerialName("url")
    public val url: String
)
