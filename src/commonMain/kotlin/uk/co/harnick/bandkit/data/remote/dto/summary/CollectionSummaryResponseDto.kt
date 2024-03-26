package uk.co.harnick.bandkit.data.remote.dto.summary

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal class CollectionSummaryResponseDto(
    @SerialName("collection_summary")
    val collectionSummaryDto: CollectionSummaryDto,
    @SerialName("fan_id")
    val ownerId: Long
)
