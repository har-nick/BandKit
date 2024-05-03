package uk.co.harnick.bandkit.data.remote.dto.items

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Suppress("UNUSED")
@Serializable
internal class PackageDetailsDto(
    val title: String,
    val description: String,
    @SerialName("private")
    val isPrivate: Boolean?,
    @SerialName("killed")
    val purchasable: Boolean?,
    @SerialName("band_id")
    val artistId: Long,
    @SerialName("label_id")
    val labelId: Long?,
    @SerialName("is_subscriber_only")
    val isSubscriberOnly: Boolean,
    @SerialName("is_live_event")
    val isLiveEvent: Boolean,
    @SerialName("live_event_type")
    val liveEventType: String?,
    val images: List<ImageDto>,
    @SerialName("band_name")
    val artistName: String,
    @SerialName("url_hints")
    val urlHints: UrlHintsDto,
    @SerialName("item_url")
    val itemUrl: String
)
