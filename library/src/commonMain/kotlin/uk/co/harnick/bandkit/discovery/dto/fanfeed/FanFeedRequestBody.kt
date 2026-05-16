package uk.co.harnick.bandkit.discovery.dto.fanfeed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal class FanFeedRequestBody(
    @SerialName("fan_id")
    val userId: Long,

    @SerialName("older_than")
    val olderThan: Long
)
