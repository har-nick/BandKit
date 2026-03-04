package uk.co.harnick.bandkit.discovery.dto.salesfeed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public class Event internal constructor(
    @SerialName("event_type")
    public val type: String,

    @SerialName("utc_date")
    public val date: Double,

    @SerialName("items")
    public val items: Long
)

