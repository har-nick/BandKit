package uk.co.harnick.bandkit.account.dto.followed.artist

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The URL data for a Bandcamp artist.
 * @property subdomain The artist's Bandcamp subdomain.
 * @property customDomain The artist's external website, if one exists.
 */
@Serializable
public class UrlHints internal constructor(
    @SerialName("subdomain")
    public val subdomain: String,

    @SerialName("custom_domain")
    public val customDomain: String?
)
