package uk.co.harnick.bandkit.library.dto.item

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public class LookupItem private constructor(
    @SerialName("item_type")
    public val type: String,

    @SerialName("purchased")
    public val isPurchased: Boolean,
)
