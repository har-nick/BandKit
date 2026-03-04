package uk.co.harnick.bandkit.discovery.dto.editorpicks

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

//  Assuming this data is similar to UrlHints. Recorded separately for safety.
@Serializable
public class UrlHash internal constructor(
    @SerialName("subdomain")
    public val subdomain: String,

    @SerialName("customDomain")
    public val customDomain: String?,

    @SerialName("customDomainVerified")
    public val customDomainVerified: JsonElement
)
