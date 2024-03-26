package uk.co.harnick.bandkit.data.remote.dto.items

import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
internal class ItemDto(
    @SerialName("fan_id")
    internal val ownerId: Long,
    @SerialName("item_id")
    internal val id: Long,
    @SerialName("item_type")
    internal val type: String,
    @SerialName("band_id")
    internal val bandId: Long,
    @SerialName("added")
    internal val dateTimeAdded: String,
    @SerialName("updated")
    internal val dateTimeUpdated: String,
    @SerialName("purchased")
    internal val dateTimePurchased: String,
    @SerialName("sale_item_id")
    internal val saleId: Long,
    @SerialName("sale_item_type")
    internal val saleType: String,
    @SerialName("tralbum_id")
    internal val trAlbumId: Long,
    @SerialName("tralbum_type")
    internal val tralbumType: String,
    @SerialName("featured_track")
    internal val featuredTrackId: Long,
    @Contextual
    @Transient
    internal val why: Any? = null,
    @SerialName("hidden")
    @Transient
    internal val isHidden: Boolean? = null,
    @Transient
    internal val index: Int? = null,
    @SerialName("also_collected_count")
    internal val saleCount: Int,
    @SerialName("url_hints")
    internal val urlHints: UrlHintsDto,
    @SerialName("item_title")
    internal val title: String,
    @SerialName("item_url")
    internal val url: String,
    @SerialName("item_art_id")
    internal val artId: Long,
    @SerialName("item_art_url")
    @Transient
    internal val artUrl: String = "",
    @SerialName("item_art")
    @Transient
    internal val art: ItemArtDto? = null,
    @SerialName("band_name")
    internal val bandName: String,
    @SerialName("band_url")
    internal val bandUrl: String,
    @SerialName("genre_id")
    @Transient
    internal val genreId: Int? = null,
    @SerialName("featured_track_title")
    internal val featuredTrackTitle: String,
    @SerialName("featured_track_number")
    internal val featuredTrackNumber: Int?,
    @SerialName("featured_track_is_custom")
    internal val featuredTrackIsCustom: Boolean,
    @SerialName("featured_track_duration")
    internal val featuredTrackDuration: Double,
    @SerialName("featured_track_url")
    internal val featuredTrackUrl: String? = null,
    @SerialName("featured_track_encodings_id")
    @Transient
    internal val featuredTrackEncodingsId: Long = 0L,
    @SerialName("package_details")
    @Transient
    internal val packageDetails: PackageDetailsDto? = null,
    @SerialName("num_streamable_tracks")
    @Transient
    internal val streamableTrackCount: Int = 0,
    @SerialName("is_purchasable")
    @Transient
    internal val isPurchasable: Boolean = false,
    @SerialName("is_private")
    @Transient
    internal val isPrivate: Boolean = false,
    @SerialName("is_preorder")
    @Transient
    internal val isPreorder: Boolean = false,
    @SerialName("is_giftable")
    @Transient
    internal val isGiftable: Boolean = false,
    @SerialName("is_subscriber_only")
    @Transient
    internal val isSubscriberOnly: Boolean = false,
    @SerialName("is_subscription_item")
    @Transient
    internal val isSubscriptionItem: Boolean = false,
    @SerialName("service_name")
    @Transient
    internal val serviceName: String? = null,
    @SerialName("service_url_fragment")
    @Transient
    internal val serviceUrlFragment: String? = null,
    @SerialName("gift_sender_name")
    @Transient
    internal val giftSenderName: String? = null,
    @SerialName("gift_sender_note")
    @Transient
    internal val giftSenderNote: String? = null,
    @SerialName("gift_id")
    @Transient
    internal val giftId: Long? = null,
    @SerialName("gift_recipient_name")
    @Transient
    internal val giftRecipientName: String? = null,
    @SerialName("album_id")
    @Transient
    internal val albumId: Long? = null,
    @SerialName("album_title")
    @Transient
    internal val albumTitle: String? = null,
    @SerialName("listen_in_app_url")
    @Transient
    internal val listenInAppUrl: String = "",
    @SerialName("band_location")
    internal val bandLocation: String? = null,
    @SerialName("band_image_id")
    @Transient
    internal val bandImageId: Long? = null,
    @SerialName("release_count")
    @Transient
    internal val releaseCount: Int = 0,
    @SerialName("message_count")
    @Transient
    internal val messageCount: Int = 0,
    @SerialName("is_set_price")
    @Transient
    internal val isSetPrice: Boolean = true,
    @Transient
    internal val price: Double = 0.00,
    @SerialName("has_digital_download")
    @Transient
    internal val hasDigitalDownload: Boolean? = null,
    @SerialName("merch_ids")
    @Transient
    internal val merchIds: List<Long>? = null,
    @SerialName("merch_sold_out")
    @Transient
    internal val merchSoldOut: Boolean? = null,
    @Transient
    internal val currency: String = "",
    internal val labelName: String? = null,
    @SerialName("label_id")
    internal val labelId: Long? = null,
    @SerialName("require_email")
    @Transient
    internal val requireEmail: Boolean? = false,
    @SerialName("item_art_ids")
    @Transient
    internal val itemArtIds: List<Long>? = listOf(),
    @Contextual
    @Transient
    internal val releases: Any? = null,
    @Contextual
    @Transient
    internal val discount: Any? = null,
    @Transient
    internal val token: String = "",
    @SerialName("variant_id")
    @Transient
    internal val variantId: Long? = null,
    @SerialName("merch_snapshot")
    @Transient
    internal val merchSnapshot: MerchSnapshotDto? = null,
    @SerialName("featured_track_license_id")
    @Transient
    internal val featuredTrackLicenseId: Long? = null,
    @SerialName("licensed_item")
    @Transient
    internal val isLicensedItem: Boolean? = null,
    @SerialName("download_available")
    internal val downloadAvailable: Boolean
)
