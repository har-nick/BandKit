package uk.co.harnick.bandkit.data.remote.dto.items

import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public class ItemDto(
    @SerialName("fan_id")
    public val ownerId: Long,
    @SerialName("item_id")
    public val id: Long,
    @SerialName("item_type")
    public val type: String,
    @SerialName("band_id")
    public val bandId: Long,
    @SerialName("added")
    public val dateTimeAdded: String,
    @SerialName("updated")
    public val dateTimeLastUpdated: String,
    @SerialName("purchased")
    public val dateTimePurchased: String,
    @SerialName("sale_item_id")
    public val purchaseId: Int,
    @SerialName("sale_item_type")
    public val parentPurchaseType: String,
    @SerialName("tralbum_id")
    public val trAlbumId: Long,
    @SerialName("tralbum_type")
    public val trAlbumType: String,
    @SerialName("featured_track")
    public val favoriteTrack: Long,
    @Contextual
    public val why: Any?,
    public val hidden: Boolean?,
    public val index: Int?,
    @SerialName("also_collected_count")
    public val timesPurchasedByOthers: Int,
    @SerialName("url_hints")
    public val urlHints: UrlHintsDto,
    @SerialName("item_title")
    public val title: String,
    @SerialName("item_url")
    public val url: String,
    @SerialName("item_art_id")
    public val artId: Long,
    @SerialName("item_art_url")
    public val artUrl: String,
    @SerialName("item_art")
    public val art: ItemArtDto,
    @SerialName("band_name")
    public val bandName: String,
    @SerialName("band_url")
    public val bandUrl: String,
    @SerialName("genre_id")
    public val genreId: Int?,
    @SerialName("featured_track_title")
    public val favoriteTrackTitle: String,
    @SerialName("featured_track_number")
    public val favoriteTrackNumber: Int?,
    @SerialName("featured_track_is_custom")
    public val favoriteTrackIsCustom: Boolean,
    @SerialName("featured_track_duration")
    public val favoriteTrackDuration: Double?,
    @SerialName("featured_track_url")
    public val favoriteTrackUrl: String?,
    @SerialName("featured_track_encodings_id")
    public val favoriteTrackEncodingId: Long?,
    @SerialName("package_details")
    public val packageDetails: PackageDetailsDto?,
    @SerialName("num_streamable_tracks")
    public val numStreamableTracks: Int,
    @SerialName("is_purchasable")
    public val isPurchasable: Boolean,
    @SerialName("is_private")
    public val isPrivate: Boolean,
    @SerialName("is_preorder")
    public val isPreorder: Boolean,
    @SerialName("is_giftable")
    public val isGiftable: Boolean,
    @SerialName("is_subscriber_only")
    public val isSubscriberOnly: Boolean,
    @SerialName("is_subscription_item")
    public val isSubscriptionItem: Boolean,
    @SerialName("service_name")
    public val serviceName: String?,
    @SerialName("service_url_fragment")
    public val serviceUrlFragment: String?,
    @SerialName("gift_sender_name")
    public val giftSenderName: String?,
    @SerialName("gift_sender_note")
    public val giftSenderNote: String?,
    @SerialName("gift_id")
    public val giftId: Long?,
    @SerialName("gift_recipient_name")
    public val giftRecipientName: String?,
    @SerialName("album_id")
    public val albumId: Long?,
    @SerialName("album_title")
    public val albumTitle: String?,
    @SerialName("listen_in_app_url")
    public val listenInAppUrl: String,
    @SerialName("band_location")
    public val bandLocation: String?,
    @SerialName("band_image_id")
    public val bandImageId: Long?,
    @SerialName("release_count")
    public val releaseCount: Int?,
    @SerialName("message_count")
    public val messageCount: Int?,
    @SerialName("is_set_price")
    public val isSetPrice: Boolean,
    public val price: Double,
    @SerialName("has_digital_download")
    public val hasDigitalDownload: Boolean?,
    @SerialName("merch_ids")
    public val merchIds: List<Long>?,
    @SerialName("merch_sold_out")
    public val merchSoldOut: Boolean?,
    public val currency: String,
    public val label: String?,
    @SerialName("label_id")
    public val labelId: Long?,
    @SerialName("require_email")
    public val requireEmail: Boolean?,
    @SerialName("item_art_ids")
    public val itemArtIds: List<Long>?,
    public val releases: Int?,
    @Contextual
    public val discount: Any?,
    public val token: String,
    @SerialName("variant_id")
    public val variantId: Long?,
    @SerialName("merch_snapshot")
    public val merchSnapshot: MerchSnapshotDto?,
    @SerialName("featured_track_license_id")
    public val favoriteTrackLicenseId: Long?,
    @SerialName("licensed_item")
    public val licensedItem: Boolean?,
    @SerialName("download_available")
    public val downloadAvailable: Boolean
)
