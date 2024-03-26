package uk.co.harnick.bandkit.data.remote.dto.items

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal class MerchSnapshotDto(
    @SerialName("package_type_id")
    internal val packageTypeId: Long?,
    @SerialName("merch_art_0")
    internal val merchArt0: Int,
    @SerialName("merch_art_1")
    internal val merchArt1: Int?,
    @SerialName("merch_art_2")
    internal val merchArt2: Int?
)