package uk.co.harnick.bandkit.data.remote.dto.items

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Suppress("UNUSED")
@Serializable
internal class UrlHintsDto(
    val subdomain: String,
    @SerialName("custom_domain")
    val customDomain: String?,
    @SerialName("custom_domain_verified")
    val customDomainVerified: Boolean?,
    val slug: String,
    @SerialName("item_type")
    val itemType: String
)
