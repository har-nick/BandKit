package uk.co.harnick.bandkit.data.remote.dto.items

import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public class PackageDetailsDto(
    public val title: String,
    public val description: String,
    @Contextual
    public val private: Any? = null,
    @Contextual
    public val killed: Any? = null,
    @SerialName("band_id")
    public val bandId: Long,
    @SerialName("label_id")
    public val labelId: Long?,
    @SerialName("is_subscriber_only")
    public val isSubscriberOnly: Boolean,
    @SerialName("is_live_event")
    public val isLiveEvent: Boolean,
    @SerialName("live_event_type")
    @Contextual
    public val liveEventType: Any? = null,
    public val images: List<ImageDto>,
    @SerialName("band_name")
    public val bandName: String,
    @SerialName("url_hints")
    public val urlHints: UrlHintsDto,
    @SerialName("item_url")
    public val itemUrl: String
)
