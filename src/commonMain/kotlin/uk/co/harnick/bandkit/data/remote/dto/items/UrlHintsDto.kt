package uk.co.harnick.bandkit.data.remote.dto.items


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public class UrlHintsDto(
    public val subdomain: String,
    @SerialName("custom_domain")
    public val customDomain: String? = null,
    @SerialName("custom_domain_verified")
    public val customDomainVerified: Boolean? = null,
    public val slug: String,
    @SerialName("item_type")
    public val itemType: String
)
