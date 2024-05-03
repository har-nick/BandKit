package uk.co.harnick.bandkit.data.model

import kotlinx.serialization.Serializable
import uk.co.harnick.bandkit.data.remote.dto.summary.CollectionSummaryResponseDto

/**
 * A summary report of a user's library. Includes hidden items.
 * @property [itemCount] The number of items in the library.
 * @property [ownerId] The ID of this summary's owner.
 * @property [ownerUsername] The username of this summary's owner.
 */
@Serializable
public data class LibrarySummary internal constructor(private val dto: CollectionSummaryResponseDto) {
    public val itemCount: Int = dto.collectionSummaryDto.albums.size
    public val ownerId: Long = dto.ownerId
    public val ownerUsername: String = dto.collectionSummaryDto.username
}
