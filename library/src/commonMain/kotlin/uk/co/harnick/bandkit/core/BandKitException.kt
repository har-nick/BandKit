package uk.co.harnick.bandkit.core

public sealed class BandKitException(override val message: String?) : Exception(message) {
    public object MissingTokenException : BandKitException("Token was not passed to plugin config.")

    public class SslRequiredException(
        url: String
    ) : BandKitException("Request to URL \"$url\" was not sent using SSL.")
}
