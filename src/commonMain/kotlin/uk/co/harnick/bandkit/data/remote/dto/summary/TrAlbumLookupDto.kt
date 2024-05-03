package uk.co.harnick.bandkit.data.remote.dto.summary

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public class TrAlbumLookupDto(
    @SerialName("item_type")
    public val itemType: String,
    @SerialName("item_id")
    public val itemId: Long,
    @SerialName("band_id")
    public val artistId: Long,
    @SerialName("purchased")
    public val datePurchased: String,
)
