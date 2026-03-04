package uk.co.harnick.bandkit.discovery.dto.salesfeed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public class EventItem(
    @SerialName("utc_date")
    public val utcDate: Double,

    @SerialName("artist_name")
    public val artistName: String,

    @SerialName("item_type")
    public val itemType: String,

    @SerialName("item_description")
    public val itemDescription: String,

    @SerialName("album_title")
    public val albumTitle: String?,

    @SerialName("slug_type")
    public val slugType: String,

    @SerialName("track_album_slug_text")
    public val trackAlbumSlugText: String?,

    @SerialName("currency")
    public val currency: String,

    @SerialName("amount_paid")
    public val amountPaid: Double,

    @SerialName("item_price")
    public val itemPrice: Double,

    @SerialName("amount_paid_usd")
    public val amountPaidUsd: Double,

    @SerialName("country")
    public val country: String,

    @SerialName("art_id")
    public val artId: Int,

    @SerialName("releases")
    public val releases: Int?,

    @SerialName("package_image_id")
    public val packageImageId: Long?,

    @SerialName("url")
    public val url: String,

    @SerialName("country_code")
    public val countryCode: String,

    @SerialName("amount_paid_fmt")
    public val regionalAmountPaid: String,

    @SerialName("art_url")
    public val artUrl: String
)