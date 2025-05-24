package uk.co.harnick.bandkit.core

public sealed class BandKitException(override val message: String) : Exception(message) {
    public object MissingTokenException : BandKitException("Token is null or blank.")

    public open class ApiException internal constructor(
        message: String
    ) : BandKitException(message)

    public class DeserializationException internal constructor(
        url: String,
        rawBody: String,
        ktxSerializationError: String?
    ) : BandKitException(
        """
            BandKit failed to deserialize response data to the model:
            ENDPOINT:           $url
            POINT OF FAILURE:   $ktxSerializationError
            RAW BODY:           \n$rawBody\n
        """.trimIndent()
    )

    public class MissingPluginException internal constructor(
        message: String
    ) : BandKitException(message)

    public class SslRequiredException(
        url: String
    ) : BandKitException("Request to URL \"$url\" was not sent using SSL.")
}
