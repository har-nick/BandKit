package uk.co.harnick.bandkit.discovery.dto.fanfeed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
public class Track internal constructor(
    @SerialName("track_id")
    public val trackId: Long,

    @SerialName("track_license_id")
    public val trackLicenseId: JsonElement,

    @SerialName("title")
    public val title: String,

    @SerialName("track_num")
    public val trackIndex: Int,

    @SerialName("streaming_url")
    public val streamingUrl: Map<String, String>,

    @SerialName("duration")
    public val duration: Float,

    @SerialName("encodings_id")
    public val encodingsId: Long,

    @SerialName("album_title")
    public val itemTitle: String,

    @SerialName("band_name")
    public val artistName: String,

    @SerialName("art_id")
    public val artId: Long,

    @SerialName("album_id")
    public val itemId: Long,

    @SerialName("is_streamable")
    public val isStreamable: Boolean,

    @SerialName("has_lyrics")
    public val hasLyrics: JsonElement,

    @SerialName("is_set_price")
    public val isSetPrice: Boolean,

    @SerialName("price")
    public val price: Float,

    @SerialName("has_digital_download")
    public val hasDigitalDownload: JsonElement,

    @SerialName("merch_ids")
    public val merchIds: List<Long>?,

    @SerialName("merch_sold_out")
    public val merchSoldOut: Boolean?,

    @SerialName("currency")
    public val currency: String,

    @SerialName("require_email")
    public val requireEmail: JsonElement,

    @SerialName("is_purchasable")
    public val isPurchasable: Boolean,

    @SerialName("band_id")
    public val artistId: Long,

    @SerialName("label")
    public val label: String?,

    @SerialName("label_id")
    public val labelId: Long?
)
