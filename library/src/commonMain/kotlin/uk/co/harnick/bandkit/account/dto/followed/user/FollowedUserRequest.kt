package uk.co.harnick.bandkit.account.dto.followed.user

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal class FollowedUserRequest(
    @SerialName("fan_id")
    internal val userId: Long,

    @SerialName("count")
    internal val itemLimit: Int,

    @SerialName("older_than_token")
    internal val olderThanToken: String
)
