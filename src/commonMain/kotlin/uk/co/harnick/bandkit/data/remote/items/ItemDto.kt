package uk.co.harnick.bandkit.data.remote.items

import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ItemDto(
    @SerialName("added")
    val dateTimeItemWasAddedToLibrary: String,
    @SerialName("album_id")
    val albumId: Long,
    @SerialName("album_title")
    val albumTitle: String,
    @SerialName("also_collected_count")
    val alsoCollectedCount: Int,
    @SerialName("band_id")
    val bandId: Long,
    @SerialName("band_image_id")
    val bandImageId: Long? = null,
    @SerialName("band_location")
    val bandLocation: String? = null,
    @SerialName("band_name")
    val bandName: String,
    @SerialName("band_url")
    val bandUrl: String,
    @SerialName("currency")
    val currency: String,
    @SerialName("discount")
    val hasDiscount: Boolean? = null,
    @SerialName("download_available")
    val canBeDownloaded: Boolean,
    @SerialName("fan_id")
    val userId: Long,
    @SerialName("featured_track")
    val featuredTrackId: Long,
    @SerialName("featured_track_duration")
    val featuredTrackDuration: Float,
    @SerialName("featured_track_encodings_id")
    val featuredTrackEncodingsId: Long,
    @SerialName("featured_track_is_custom")
    val featuredTrackIsCustom: Boolean,
    @SerialName("featured_track_license_id")
    val featuredTrackLicenseId: Long? = null,
    @SerialName("featured_track_number")
    val featuredTrackNumber: Int,
    @SerialName("featured_track_title")
    val featuredTrackTitle: String,
    @SerialName("featured_track_url")
    val featuredTrackUrl: String,
    @SerialName("genre_id")
    val genreId: Int,
    @SerialName("gift_id")
    val giftId: Long? = null,
    @SerialName("gift_recipient_name")
    val giftRecipientName: String? = null,
    @SerialName("gift_sender_name")
    val giftSenderName: String? = null,
    @SerialName("gift_sender_note")
    val giftSenderNote: String? = null,
    @SerialName("has_digital_download")
    val hasDigitalDownload: Boolean? = null,
    @SerialName("hidden")
    val hidden: Boolean? = null,
    @SerialName("index")
    val index: Int? = null,
    @SerialName("is_giftable")
    val isGiftable: Boolean,
    @SerialName("is_preorder")
    val isPreorder: Boolean,
    @SerialName("is_private")
    val isPrivate: Boolean,
    @SerialName("is_purchasable")
    val isPurchasable: Boolean,
    @SerialName("is_set_price")
    val isSetPrice: Boolean,
    @SerialName("is_subscriber_only")
    val isSubscriberOnly: Boolean,
    @SerialName("is_subscription_item")
    val isSubscriptionItem: Boolean,
    @SerialName("item_art")
    val itemArt: ItemArtDto,
    @SerialName("item_art_id")
    val itemArtId: Long,
    @SerialName("item_art_ids")
    val itemArtIds: Long? = null,
    @SerialName("item_art_url")
    val itemArtUrl: String,
    @SerialName("item_id")
    val itemId: Long,
    @SerialName("item_title")
    val itemTitle: String,
    @SerialName("item_type")
    val itemType: String,
    @SerialName("item_url")
    val itemUrl: String,
    @SerialName("label")
    val label: String,
    @SerialName("label_id")
    val labelId: Long,
    @SerialName("licensed_item")
    val isLicensedItem: Boolean? = null,
    @SerialName("listen_in_app_url")
    val listenInAppUrl: String,
    @SerialName("merch_ids")
    val merchIds: List<Long>?,
    @SerialName("merch_snapshot")
    val merchSnapshot: Map<String, Long>,
    @SerialName("merch_sold_out")
    val merchSoldOut: Boolean,
    @SerialName("message_count")
    val messageCount: Int? = null,
    @SerialName("num_streamable_tracks")
    val numStreamableTracks: Int,
    @SerialName("package_details")
    @Contextual
    val packageDetails: Any? = null,
    @SerialName("price")
    val price: String,
    @SerialName("purchased")
    val purchased: String,
    @SerialName("release_count")
    val releaseCount: Int? = null,
    @SerialName("releases")
    val releases: Int? = null,
    @SerialName("require_email")
    val requireEmail: Boolean? = null,
    @SerialName("sale_item_id")
    val saleItemId: Long,
    @SerialName("sale_item_type")
    val saleItemType: String,
    @SerialName("service_name")
    val serviceName: String? = null,
    @SerialName("service_url_fragment")
    val serviceUrlFragment: String? = null,
    @SerialName("token")
    val token: String,
    @SerialName("tralbum_id")
    val tralbumId: Long,
    @SerialName("tralbum_type")
    val tralbumType: String,
    @SerialName("updated")
    val dateTimeLastUpdated: String,
    @SerialName("url_hints")
    val urlHints: UrlHintsDto,
    @SerialName("variant_id")
    val variantId: Long? = null,
    @SerialName("why")
    @Contextual
    val why: Any? = null
)
