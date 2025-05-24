package uk.co.harnick.bandkit.discovery.dto.fanfeed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public class FanFeedResponse private constructor(
    @SerialName("okay")
    public val okay: Boolean,


    )
