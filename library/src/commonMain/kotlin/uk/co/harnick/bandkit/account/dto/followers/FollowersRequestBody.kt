package uk.co.harnick.bandkit.account.dto.followers

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal class FollowersRequestBody(
    @SerialName("fan_id")
    val userId: Long,

    @SerialName("older_than_token")
    val olderThanToken: String,

    @SerialName("count")
    val accountLimit: Int
)
