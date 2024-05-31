package uk.co.harnick.bandkit.data.remote.dto.items

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal class ItemDto(
    @SerialName("fan_id")
    val fanId: Long,
    @SerialName("item_id")
    val itemId: Long,
    @SerialName("item_type")
    val itemType: String,
    @SerialName("band_id")
    val bandId: Long,
    @SerialName("added")
    val dateTimeAdded: String,
    @SerialName("updated")
    val dateTimeUpdated: String,
    @SerialName("purchased")
    val dateTimePurchased: String,
    @SerialName("sale_item_id")
    val saleId: Long,
    @SerialName("sale_item_type")
    val saleType: String,
    @SerialName("tralbum_id")
    val trAlbumId: Long,
    @SerialName("tralbum_type")
    val albumType: String,
    @SerialName("featured_track")
    val favoriteTrackId: Long,
    // Guessed type
    val why: String? = null,
    // Guessed type
    @SerialName("hidden")
    val isHidden: Boolean? = null,
    val index: Int?,
    @SerialName("also_collected_count")
    val alsoPurchasedCount: Int,
    @SerialName("url_hints")
    val urlHints: UrlHintsDto,
    @SerialName("item_title")
    val title: String,
    @SerialName("item_url")
    val url: String,
    @SerialName("item_art_id")
    val artId: Long,
    @SerialName("item_art_url")
    val artUrl: String,
    @SerialName("item_art")
    val art: ItemArtDto,
    @SerialName("band_name")
    val artistName: String,
    @SerialName("band_url")
    val artistUrl: String,
    @SerialName("genre_id")
    val genreId: Long?,
    @SerialName("featured_track_title")
    val favoriteTrackTitle: String,
    @SerialName("featured_track_number")
    val favoriteTrackIndex: Int?,
    @SerialName("featured_track_is_custom")
    val favoriteTrackIsCustom: Boolean,
    @SerialName("featured_track_duration")
    val favoriteTrackDuration: Float,
    @SerialName("featured_track_url")
    val favoriteTrackUrl: String?,
    @SerialName("featured_track_encodings_id")
    val favoriteTrackEncodingsId: Long,
    @SerialName("package_details")
    val packageDetails: PackageDetailsDto?,
    @SerialName("num_streamable_tracks")
    val streamableTrackCount: Int,
    @SerialName("is_purchasable")
    val isPurchasable: Boolean,
    @SerialName("is_private")
    val isPrivate: Boolean,
    @SerialName("is_preorder")
    val isPreorder: Boolean,
    @SerialName("is_giftable")
    val isGiftable: Boolean,
    @SerialName("is_subscriber_only")
    val isSubscriberOnly: Boolean,
    @SerialName("is_subscription_item")
    val isSubscriptionItem: Boolean,
    @SerialName("service_name")
    val serviceName: String?,
    @SerialName("service_url_fragment")
    val serviceUrlFragment: String?,
    @SerialName("gift_sender_name")
    val giftSenderName: String?,
    @SerialName("gift_sender_note")
    val giftSenderNote: String?,
    @SerialName("gift_id")
    val giftId: Long?,
    @SerialName("gift_recipient_name")
    val giftRecipientName: String?,
    @SerialName("album_id")
    val albumId: Long?,
    @SerialName("album_title")
    val albumTitle: String?,
    @SerialName("listen_in_app_url")
    val listenInAppUrl: String,
    @SerialName("band_location")
    val artistLocation: String?,
    @SerialName("band_image_id")
    val artistImageId: Long?,
    @SerialName("release_count")
    val releaseCount: Int?,
    @SerialName("message_count")
    val messageCount: String?,
    @SerialName("is_set_price")
    val isSetPrice: Boolean,
    val price: Float,
    @SerialName("has_digital_download")
    val hasDigitalDownload: Boolean?,
    @SerialName("merch_ids")
    val merchIds: List<Long>?,
    @SerialName("merch_sold_out")
    val merchSoldOut: Boolean?,
    val currency: String,
    @SerialName("label")
    val labelName: String?,
    @SerialName("label_id")
    val labelId: Long?,
    @SerialName("require_email")
    val requireEmail: Boolean?,
    @SerialName("item_art_ids")
    val artIds: List<Long>?,
    // Guessed type.
    val releases: Int? = null,
    // Guessed type
    val discount: Float? = null,
    val token: String,
    @SerialName("variant_id")
    val variantId: Long?,
    @SerialName("merch_snapshot")
    // Guessed type. Likely a class.
    val merchSnapshot: Map<String, Long?>? = null,
    @SerialName("featured_track_license_id")
    val favoriteTrackLicenseId: Long?,
    @SerialName("licensed_item")
    // Guessed type
    val licensedItem: Boolean? = null,
    @SerialName("download_available")
    val downloadAvailable: Boolean
)
