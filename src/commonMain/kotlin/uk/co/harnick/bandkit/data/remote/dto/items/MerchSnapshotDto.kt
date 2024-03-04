package uk.co.harnick.bandkit.data.remote.dto.items


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public class MerchSnapshotDto(
    @SerialName("package_type_id")
    public val packageTypeId: Long?,
    @SerialName("merch_art_0")
    public val merchArt0: Int,
    @SerialName("merch_art_1")
    public val merchArt1: Int?,
    @SerialName("merch_art_2")
    public val merchArt2: Int?
)
