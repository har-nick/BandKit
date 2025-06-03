package uk.co.harnick.bandkit.account.dto.followers

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class FollowersRequest(
    @SerialName("fan_id")
    internal val userId: Long,

    @SerialName("older_than_token")
    internal val olderThanToken: String,

    @SerialName("count")
    internal val accountLimit: Int
)
