package uk.co.harnick.bandkit.discovery.dto.editorpicks

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public class CardData internal constructor(
    @SerialName("artistName")
    public val artistName: String,

    @SerialName("description")
    public val description: String,

    @SerialName("genre")
    public val genre: String,

    @SerialName("imageId")
    public val imageId: Long,

    @SerialName("itemId")
    public val itemId: Long,

    @SerialName("itemType")
    public val itemType: String,

    @SerialName("itemUrl")
    public val itemUrl: String,

    @SerialName("title")
    public val title: String,

    @SerialName("trackId")
    public val trackId: Long
)
