package uk.co.harnick.bandkit.discovery.dto.editorpicks

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public class AlbumData internal constructor(
    @SerialName("id")
    public val id: Long,

    @SerialName("title")
    public val title: String,

    @SerialName("artId")
    public val artId: Long,

    @SerialName("bandId")
    public val artistId : Long,

    @SerialName("bandImageId")
    public val artistImageId: Long,

    @SerialName("isPreorder")
    public val isPreorder: Boolean,

    @SerialName("isPurchasable")
    public val isPurchasable: Boolean,

    @SerialName("isFreeDownload")
    public val isFreeDownload: Boolean,

    @SerialName("isSetPrice")
    public val isSetPrice: Boolean,

    @SerialName("price")
    public val price: Float,

    @SerialName("url")
    public val url: String,

    @SerialName("isWishlisted")
    public val isWishlisted: Boolean,

    @SerialName("isOwned")
    public val isOwned: Boolean
)
