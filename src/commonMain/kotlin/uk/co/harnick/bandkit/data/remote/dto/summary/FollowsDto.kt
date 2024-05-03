package uk.co.harnick.bandkit.data.remote.dto.summary

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public class FollowsDto(
    @SerialName("following")
    public val following: Map<Long, Boolean>
)
