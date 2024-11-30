package uk.co.harnick.bandkit.library.dto.item

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import uk.co.harnick.bandkit.util.UnknownType

@Serializable
public class UrlHintsDto private constructor(
    @SerialName("subdomain")
    public val subdomain: String,

    @SerialName("custom_domain")
    public val customDomain: UnknownType,

    @SerialName("custom_domain_verified")
    public val customDomainIsVerified: UnknownType,

    @SerialName("slug")
    public val slug: String,

    @SerialName("item_type")
    public val itemType: String
)
