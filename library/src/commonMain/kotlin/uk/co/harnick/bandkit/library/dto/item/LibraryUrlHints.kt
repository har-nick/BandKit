package uk.co.harnick.bandkit.library.dto.item

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
public class LibraryUrlHints internal constructor(
    @SerialName("subdomain")
    public val subdomain: String,

    @SerialName("custom_domain")
    public val customDomain: String?,

    @SerialName("custom_domain_verified")
    public val customDomainIsVerified: JsonElement,

    @SerialName("slug")
    public val slug: String,

    @SerialName("item_type")
    public val itemType: String
)
