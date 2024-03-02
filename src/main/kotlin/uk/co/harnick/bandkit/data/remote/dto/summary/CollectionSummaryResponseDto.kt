package uk.co.harnick.bandkit.data.remote.dto.summary

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public class CollectionSummaryResponseDto(
    @SerialName("collection_summary")
    public val collectionSummaryDto: CollectionSummaryDto,
    @SerialName("fan_id")
    public val fanId: Long
)
