package uk.co.harnick.bandkit.account.dto.followed.artist

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import uk.co.harnick.bandkit.util.UnknownType

@Serializable
public class FollowedArtistUrlHintsDto private constructor(
    @SerialName("subdomain")
    public val subdomain: String,

    @SerialName("custom_domain")
    public val customDomain: UnknownType
)
