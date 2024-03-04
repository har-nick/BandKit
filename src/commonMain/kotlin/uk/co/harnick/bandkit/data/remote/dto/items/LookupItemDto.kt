package uk.co.harnick.bandkit.data.remote.dto.items

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public class LookupItemDto(
    @SerialName("item_type")
    public val itemType: String,
    public val purchased: Boolean
)
