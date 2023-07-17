package data.remote.items

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ItemLookupDto(
    @SerialName("item_type")
    val itemType: String,
    @SerialName("purchased")
    val isPurchased: String
)
