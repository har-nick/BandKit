package data.remote.summary

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CollectionSummaryResponseDto(
    @SerialName("collection_summary")
    val collectionSummary: CollectionSummaryDto,
    @SerialName("fan_id")
    val fanId: Long
)
