package uk.co.harnick.bandkit.discovery.dto.fanfeed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public class FanFeedRequest internal constructor(
    @SerialName("fan_id")
    public val userId: Long,

    @SerialName("older_than")
    public val olderThan: Long
)
