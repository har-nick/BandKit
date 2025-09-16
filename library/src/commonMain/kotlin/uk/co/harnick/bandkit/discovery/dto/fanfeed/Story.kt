package uk.co.harnick.bandkit.discovery.dto.fanfeed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
public class Story internal constructor(
    @SerialName("item_id")
    public val itemId: Long,

    @SerialName("item_type")
    public val itemType: String,

    @SerialName("tralbum_id")
    public val tralbumId: Long,

    @SerialName("tralbum_type")
    public val tralbumType: String,

    @SerialName("band_id")
    public val bandId: Long,

    @SerialName("story_date")
    public val storyDate: String,

    @SerialName("new_date")
    public val newDate: JsonElement,

    @SerialName("is_subscription_item")
    public val isSubscriptionItem: JsonElement,

    @SerialName("story_type")
    public val storyType: String,

    @SerialName("fan_id")
    public val fanId: Long,

    @SerialName("tags")
    public val tags: List<Tag>,

    @SerialName("item_title")
    public val itemTitle: String,

    @SerialName("item_url")
    public val itemUrl: String,

    @SerialName("item_art_url")
    public val itemArtUrl: String,

    @SerialName("item_art_id")
    public val itemArtId: Long,

    @SerialName("item_art")
    public val itemArt: ItemArt,

    @SerialName("item_art_ids")
    public val itemArtIds: JsonElement,

    @SerialName("releases")
    public val releases: JsonElement,

    @SerialName("discount")
    public val discount: JsonElement,

    @SerialName("url_hints")
    public val urlHints: UrlHints,

    @SerialName("band_name")
    public val artistName: String,

    @SerialName("band_url")
    public val artistUrl: String,

    @SerialName("genre_id")
    public val genreId: Long,

    @SerialName("is_purchasable")
    public val isPurchasable: Boolean,

    @SerialName("currency")
    public val currency: String,

    @SerialName("is_set_price")
    public val isSetPrice: Boolean,

    @SerialName("price")
    public val price: Float,

    @SerialName("merch_ids")
    public val merchIds: List<Long>?,

    @SerialName("merch_sold_out")
    public val merchSoldOut: Boolean?,

    @SerialName("label")
    public val label: String?,

    @SerialName("label_id")
    public val labelId: Long?,

    @SerialName("is_private")
    public val isPrivate: Boolean,

    @SerialName("is_preorder")
    public val isPreorder: Boolean,

    @SerialName("is_giftable")
    public val isGiftable: Boolean,

    @SerialName("is_subscriber_only")
    public val isSubscriberOnly: Boolean,

    @SerialName("album_id")
    public val albumId: Long,

    @SerialName("album_title")
    public val albumTitle: String,

    @SerialName("band_location")
    public val artistLocation: String,

    @SerialName("band_image_id")
    public val artistImageId: Long?,

    @SerialName("release_count")
    public val releaseCount: JsonElement,

    @SerialName("message_count")
    public val messageCount: JsonElement,

    @SerialName("service_name")
    public val serviceName: JsonElement,

    @SerialName("service_url_fragment")
    public val serviceUrlFragment: JsonElement,

    @SerialName("featured_track_is_custom")
    public val featuredTrackIsCustom: Boolean,

    @SerialName("featured_track_url")
    public val featuredTrackUrl: JsonElement,

    @SerialName("featured_track")
    public val featuredTrackId: Long,

    @SerialName("featured_track_title")
    public val featuredTrackTitle: String,

    @SerialName("featured_track_number")
    public val featuredTrackIndex: Int,

    @SerialName("featured_track_duration")
    public val featuredTrackDuration: Float,

    @SerialName("featured_track_encodings_id")
    public val featuredTrackEncodingsId: Long,

    @SerialName("featured_track_license_id")
    public val featuredTrackLicenseId: JsonElement,

    @SerialName("num_streamable_tracks")
    public val numStreamableTracks: Int,

    @SerialName("download_available")
    public val downloadAvailable: Boolean,

    @SerialName("also_collected_count")
    public val alsoCollectedCount: Int,

    @SerialName("art_ids")
    public val artIds: List<Long>
)
