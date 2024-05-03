package uk.co.harnick.bandkit.data.remote.dto.items

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Suppress("UNUSED")
@Serializable
internal class MerchSnapshotDto(
    @SerialName("package_type_id")
    val packageTypeId: Long?,
    @SerialName("merch_art_0")
    val merchArt0: Long,
    @SerialName("merch_art_1")
    val merchArt1: Long,
    @SerialName("merch_art_2")
    val merchArt2: Long
)
