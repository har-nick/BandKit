package uk.co.harnick.bandkit.discovery.dto.editorpicks

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public class Album internal constructor(
    @SerialName("id")
    public val id: Long,

    @SerialName("title")
    public val title: String,

    @SerialName("artId")
    public val artId: Long,

    @SerialName("bandId")
    public val bandId: Long,

    @SerialName("bandImageId")
    public val bandImageId: Long,

    @SerialName("isPreorder")
    public val isPreorder: Boolean,

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

    @SerialName("isWishlisted")
    public val isWishlisted: Boolean,

    @SerialName("isOwned")
    public val isOwned: Boolean
)
