package data.remote.summary

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TrAlbumLookupDto(
    @SerialName("item_type")
    val itemType: String,
    @SerialName("item_id")
    val itemId: Long,
    @SerialName("band_id")
    val bandId: Long,
    @SerialName("purchased")
    val datePurchased: String,
)
