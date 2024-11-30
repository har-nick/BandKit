package uk.co.harnick.bandkit.library.dto.item

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import uk.co.harnick.bandkit.util.UnknownType

@Serializable
public class LibraryItemDto private constructor(
    @SerialName("fan_id")
    public val ownerId: Long,

    @SerialName("item_id")
    public val id: Long,

    @SerialName("item_type")
    public val type: String,

    @SerialName("band_id")
    public val artistId: Long,

    @SerialName("added")
    public val dateAddedToLibrary: String,

    @SerialName("updated")
    public val dateLastUpdated: String,

    @SerialName("purchased")
    public val datePurchased: String,

    @SerialName("sale_item_id")
    public val saleId: Long,

    @SerialName("sale_item_type")
    public val saleItemType: String,

    @SerialName("tralbum_id")
    public val trAlbumId: String,

    @SerialName("tralbum_type")
    public val trAlbumType: String,

    // CAUTION: This public val ue is set regardless of a track being a user's favourite.
    //          Use `featured_track_is_custom` as a signifier of a favourite track existing.
    @SerialName("featured_track")
    public val favoriteTrackId: Long,

    @SerialName("why")
    public val why: UnknownType,

    @SerialName("hidden")
    public val hidden: UnknownType,

    // NOTE:    Only set in last item in response.
    //          public val ue = (item's index in item list) - (total number of items hidden from library).
    //          Unsure of its use, or where to find a reference for the amount of hidden items yet.
    @SerialName("index")
    public val index: Int?,

    @SerialName("also_collected_count")
    public val alsoCollectedByCount: Int,

    @SerialName("url_hints")
    public val urlHints: UrlHintsDto,

    @SerialName("item_title")
    public val itemTitle: String,

    @SerialName("item_url")
    public val itemUrl: String,

    @SerialName("item_art_id")
    public val artId: Long,

    @SerialName("item_art_url")
    public val artUrl: String,

    // NOTE: Contained Urls are not lossless.
    @SerialName("item_art")
    public val artInfo: ArtInfoDto,

    @SerialName("band_name")
    public val artistName: String,

    @SerialName("band_url")
    public val artistUrl: String,

    // MORE INFO NEEDED:    Queryable endpoints that take genre info take a string ("electronic").
    //                      No idea how to relate the two yet.
    @SerialName("genre_id")
    public val genreId: Long,

    @SerialName("featured_track_title")
    public val favoriteTrackTitle: String,

    // NOTE:    This is the track's index in its relevant tracklist.
    @SerialName("featured_track_number")
    public val favoriteTrackIndex: String,

    @SerialName("featured_track_is_custom")
    public val hasFavoriteTrack: Boolean,

    @SerialName("featured_track_duration")
    public val favoriteTrackDuration: Float,

    @SerialName("featured_track_url")
    public val favoriteTrackUrl: String?,

    // MORE INFO NEEDED:    This seems useful, but I've not idea where to reference it.
    //                      Noted anyways for further analysis.
    @SerialName("featured_track_encodings_id")
    public val favoriteTrackEncodingId: Long,

    @SerialName("package_details")
    public val packageDetails: PackageDetailsDto?,

    @SerialName("num_streamable_tracks")
    public val streamableTrackCount: Int,

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
    public val isSubscriptionOnly: Boolean,

    @SerialName("service_name")
    public val serviceName: UnknownType,

    @SerialName("service_url_fragment")
    public val serviceUrlFragment: UnknownType,

    @SerialName("gift_sender_name")
    public val giftSenderName: UnknownType,

    @SerialName("gift_sender_note")
    public val giftSenderNote: UnknownType,

    @SerialName("gift_id")
    public val giftId: UnknownType,

    @SerialName("gift_recipient_name")
    public val giftRecipientName: UnknownType,

    @SerialName("album_id")
    public val albumId: Long?,

    @SerialName("album_title")
    public val albumTitle: String?,

    // NOTE:    Intended for use in the Bandcamp app.
    //          Useless otherwise, as far as I know.
    @SerialName("listen_in_app_url")
    public val listenInAppUrl: String,

    @SerialName("band_location")
    public val artistLocation: String?,

    @SerialName("band_image_id")
    public val artistImageId: Long?,

    @SerialName("release_count")
    public val releaseCount: UnknownType,

    @SerialName("message_count")
    public val messageCount: UnknownType,

    @SerialName("is_set_price")
    public val isSetPrice: Boolean,

    @SerialName("price")
    public val price: Float,

    @SerialName("has_digital_download")
    public val hasDigitalDownload: UnknownType,

    @SerialName("merch_id")
    public val merchIds: List<Long>?,

    @SerialName("merch_sold_out")
    public val merchSoldOut: Boolean?,

    @SerialName("currency")
    public val currency: String,

    @SerialName("label")
    public val labelName: String?,

    @SerialName("label_id")
    public val labelId: Long?,

    // MORE INFO NEEDED:    Required for what purpose?
    @SerialName("require_email")
    public val emailIsRequired: UnknownType,

    @SerialName("item_art_ids")
    public val itemArtIds: UnknownType,

    @SerialName("releases")
    public val releases: UnknownType,

    @SerialName("discount")
    public val discount: UnknownType,

    @SerialName("token")
    public val token: String,

    @SerialName("variant_id")
    public val variantId: UnknownType,

    @SerialName("merch_snapshot")
    public val merchSnapshot: ItemDtoMerchSnapshot?,

    @SerialName("featured_track_license_id")
    public val featuredTrackLicenseId: UnknownType,

    @SerialName("licensed_item")
    public val licensedItem: UnknownType,

    @SerialName("download_available")
    public val downloadAvailable: Boolean,
)
