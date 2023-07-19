package uk.co.harnick.bandkit.data.remote.summary

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FollowsDto(
    @SerialName("following")
    val following: FollowingDto
)
