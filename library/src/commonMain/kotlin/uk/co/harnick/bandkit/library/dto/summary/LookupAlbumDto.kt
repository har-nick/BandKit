package uk.co.harnick.bandkit.library.dto.summary

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public class LookupAlbumDto internal constructor(
    @SerialName("item_type")
    public val type: String,

    @SerialName("item_id")
    public val id: Long,

    @SerialName("band_id")
    public val artistId: Long,

    @SerialName("purchased")
    public val datePurchased: String
)
