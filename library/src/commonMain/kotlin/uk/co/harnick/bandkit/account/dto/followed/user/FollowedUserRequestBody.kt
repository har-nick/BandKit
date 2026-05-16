package uk.co.harnick.bandkit.account.dto.followed.user

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal class FollowedUserRequestBody(
    @SerialName("fan_id")
    val userId: Long,

    @SerialName("count")
    val itemLimit: Int,

    @SerialName("older_than_token")
    val olderThanToken: String
)
