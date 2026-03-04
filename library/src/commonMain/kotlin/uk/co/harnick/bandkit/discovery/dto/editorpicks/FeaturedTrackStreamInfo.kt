package uk.co.harnick.bandkit.discovery.dto.editorpicks

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
public class FeaturedTrackStreamInfo internal constructor(
    @SerialName("encodingsId")
    public val encodingsId: Long,

    @SerialName("streamType")
    public val streamType: String,

    @SerialName("format")
    public val format: Long,

    @SerialName("fileId")
    public val fileId: Long,

    @SerialName("metadataCrc")
    public val metadataCrc: JsonElement
)
