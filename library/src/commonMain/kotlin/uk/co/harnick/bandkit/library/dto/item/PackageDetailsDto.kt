package uk.co.harnick.bandkit.library.dto.item

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import uk.co.harnick.bandkit.util.UnknownType

@Serializable
public class PackageDetailsDto private constructor(
    @SerialName("title")
    public val title: String,

    @SerialName("description")
    public val description: String,

    @SerialName("private")
    public val private: UnknownType,

    @SerialName("killed")
    public val killed: UnknownType,

    @SerialName("band_id")
    public val artistId: Long,

    @SerialName("label_id")
    public val labelId: Long?,

    @SerialName("is_subscriber_only")
    public val isSubscriberOnly: Boolean,

    @SerialName("is_live_event")
    public val isLiveEvent: Boolean,

    @SerialName("live_event_type")
    public val liveEventType: UnknownType,

    @SerialName("images")
    public val images: List<PackageDetailsImageDto>,

    @SerialName("band_name")
    public val artistName: String,

    @SerialName("url_hints")
    public val urlHintsDto: UrlHintsDto,

    @SerialName("item_url")
    public val itemUrl: String
)
