package uk.co.harnick.bandkit.library.dto.summary

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public class LibrarySummaryResponseDto internal constructor(
    @SerialName("fan_id")
    public val ownerId: Long,

    @SerialName("collection_summary")
    public val summary: LibrarySummaryDto
)
