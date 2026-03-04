package uk.co.harnick.bandkit.discovery.dto.editorpicks

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public class NotableItem internal constructor(
    @SerialName("id")
    public val id: Long,

    @SerialName("publishedDate")
    public val publishedDate: String,

    @SerialName("urlHash")
    public val urlHash: UrlHash,

    @SerialName("tralbumSlug")
    public val albumSlug: String,

    @SerialName("featuredTrackSlug")
    public val featuredTrackSlug: String,

    @SerialName("audioTrackId")
    public val featuredTrackId: Long,

    @SerialName("streamInfos")
    public val featuredTrackStreamInfo: Map<Long, FeaturedTrackStreamInfo>,

    @SerialName("cardData")
    public val cardData: CardData,

    @SerialName("playerData")
    public val playerData: PlayerData
)
