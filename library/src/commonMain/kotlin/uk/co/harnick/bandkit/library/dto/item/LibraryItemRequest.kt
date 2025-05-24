package uk.co.harnick.bandkit.library.dto.item

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class LibraryItemRequest(
    @SerialName("fan_id")
    internal val userId: Long,

    @SerialName("older_than_token")
    internal val olderThanToken: String,

    @SerialName("count")
    internal val itemLimit: Int
)
