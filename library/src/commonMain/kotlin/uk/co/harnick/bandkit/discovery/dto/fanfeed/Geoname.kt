package uk.co.harnick.bandkit.discovery.dto.fanfeed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public class Geoname internal constructor(
    @SerialName("id")
    public val id: Long,
    
    @SerialName("name")
    public val name: String,
    
    @SerialName("fullname")
    public val fullName: String
)
