package uk.co.harnick.bandkit.data.remote.items

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UrlHintsDto(
    @SerialName("custom_domain")
    val customDomain: Boolean? = null,
    @SerialName("custom_domain_verified")
    val customDomainVerified: Boolean? = null,
    @SerialName("item_type")
    val itemType: String,
    @SerialName("slug")
    val slug: String,
    @SerialName("subdomain")
    val subdomain: String
)
