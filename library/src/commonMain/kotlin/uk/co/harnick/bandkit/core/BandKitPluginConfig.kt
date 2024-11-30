package uk.co.harnick.bandkit.core

import uk.co.harnick.bandkit.core.BandKitException.MissingTokenException

// TODO: Implement
public class BandKitPluginConfig {
    public var token: String = throw MissingTokenException
    public var userAgent: String =
        "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/130.0.0.0 Safari/537.36"
    public var ignoreUnknownKeys: Boolean = true
    public var disablePersistentCache: Boolean = false
}
