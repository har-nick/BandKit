package uk.co.harnick.bandkit.data.remote.dto.items

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal class LookupItemDto(
    @SerialName("item_type")
    val itemType: String,
    val purchased: Boolean
)
