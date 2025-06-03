package uk.co.harnick.bandkit.library.dto.item

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
public class ItemDtoMerchSnapshot internal constructor(
    @SerialName("package_type_id")
    public val packageTypeId: JsonElement,

    @SerialName("merch_art_0")
    public val merchArt0: Long?,

    @SerialName("merch_art_1")
    public val merchArt1: Long?,

    @SerialName("merch_art_2")
    public val merchArt2: Long?,
)
