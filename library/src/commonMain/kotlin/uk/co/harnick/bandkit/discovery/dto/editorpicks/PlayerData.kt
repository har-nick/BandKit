package uk.co.harnick.bandkit.discovery.dto.editorpicks

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public class PlayerData internal constructor(
    @SerialName("album")
    public val album: Album,

    @SerialName("id")
    public val id: Long,

    @SerialName("title")
    public val title: String,

    @SerialName("bandId")
    public val bandId: Long,

    @SerialName("artistName")
    public val artistName: String,

    @SerialName("duration")
    public val duration: Float,

    @SerialName("artId")
    public val artId: Long?,

    @SerialName("isPurchasable")
    public val isPurchasable: Boolean,

    @SerialName("isFreeDownload")
    public val isFreeDownload: Boolean,

    @SerialName("isSetPrice")
    public val isSetPrice: Boolean,

    @SerialName("price")
    public val price: Double,

    @SerialName("url")
    public val url: String,

    @SerialName("bandUrl")
    public val bandUrl: String,

    @SerialName("streamUrl")
    public val streamUrl: String,

    @SerialName("isWishlisted")
    public val isWishlisted: Boolean,

    @SerialName("isOwned")
    public val isOwned: Boolean
)
