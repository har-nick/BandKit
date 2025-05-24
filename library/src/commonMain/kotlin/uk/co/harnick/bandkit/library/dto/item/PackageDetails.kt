package uk.co.harnick.bandkit.library.dto.item

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
public class PackageDetails private constructor(
    @SerialName("title")
    public val title: String,

    @SerialName("description")
    public val description: String,

    @SerialName("private")
    public val private: JsonElement,

    @SerialName("killed")
    public val killed: JsonElement,

    @SerialName("band_id")
    public val artistId: Long,

    @SerialName("label_id")
    public val labelId: Long?,

    @SerialName("is_subscriber_only")
    public val isSubscriberOnly: Boolean,

    @SerialName("is_live_event")
    public val isLiveEvent: Boolean,

    @SerialName("live_event_type")
    public val liveEventType: JsonElement,

    @SerialName("images")
    public val images: List<PackageDetailsImage>,

    @SerialName("band_name")
    public val artistName: String,

    @SerialName("url_hints")
    public val urlHints: UrlHints,

    @SerialName("item_url")
    public val itemUrl: String
)
