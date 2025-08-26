package uk.co.harnick.bandkit.core

public sealed class BandKitException(override val message: String) : Exception(message) {
    public open class ApiException internal constructor(
        message: String
    ) : BandKitException(message)

    public class MissingPluginException internal constructor(
        message: String
    ) : BandKitException(message)

    public class MissingTokenException internal constructor(
        message: String = "Request requires a Bandcamp token, which is null or blank."
    ): BandKitException(message)

    public class SslRequiredException(
        url: String
    ) : BandKitException("Request to URL \"$url\" was not sent using SSL.")
}
