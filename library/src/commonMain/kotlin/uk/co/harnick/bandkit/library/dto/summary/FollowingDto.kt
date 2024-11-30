package uk.co.harnick.bandkit.library.dto.summary

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public class FollowingDto internal constructor(
    @SerialName("following")
    public val following: Map<Long, Boolean>?,
)
