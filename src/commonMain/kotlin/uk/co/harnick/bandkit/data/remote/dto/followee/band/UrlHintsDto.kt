package uk.co.harnick.bandkit.data.remote.dto.followee.band

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Suppress("UNUSED")
@Serializable
internal class UrlHintsDto(
    val subdomain: String,
    @SerialName("custom_domain")
    val domainIsCustom: Boolean?
)
