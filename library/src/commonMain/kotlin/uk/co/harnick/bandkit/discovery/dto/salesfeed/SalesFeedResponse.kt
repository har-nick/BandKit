package uk.co.harnick.bandkit.discovery.dto.salesfeed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public class SalesFeedResponse internal constructor(
    @SerialName("start_date")
    public val startDate: Long,

    @SerialName("end_date")
    public val endDate: Long,

    @SerialName("data_delay_sec")
    public val dataDelay: Int,

    @SerialName("events")
    public val events: List<Event>,

    @SerialName("server_time")
    public val requestTime: Long
)
