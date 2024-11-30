package uk.co.harnick.bandkit.library.dto.item

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal class LibraryItemRequestDto(
    @SerialName("fan_id")
    internal val userId: Long,

    @SerialName("count")
    internal val itemLimit: Int,

    @SerialName("older_than_token")
    internal val olderThanToken: String
)
