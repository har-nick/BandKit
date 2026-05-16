package uk.co.harnick.bandkit.library.dto.item

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal class LibraryItemRequest(
    @SerialName("fan_id")
    val userId: Long,

    @SerialName("older_than_token")
    val olderThanToken: String,

    @SerialName("count")
    val itemLimit: Int
)
