package uk.co.harnick.bandkit.data.remote.summary

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import uk.co.harnick.bandkit.data.remote.summary.CollectionSummaryDto

@Serializable
data class CollectionSummaryResponseDto(
    @SerialName("collection_summary")
    val collectionSummary: CollectionSummaryDto,
    @SerialName("fan_id")
    val fanId: Long
)
