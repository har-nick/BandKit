package uk.co.harnick.bandkit.discovery.dto.fanfeed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public class Tag internal constructor(
    @SerialName("name")
    public val name: String,

    @SerialName("norm_name")
    public val apiName: String,

    @SerialName("isloc")
    public val isLocation: Boolean,

    @SerialName("loc_id")
    public val locationId: Long?,

    @SerialName("geoname")
    public val geoname: Geoname?
)
