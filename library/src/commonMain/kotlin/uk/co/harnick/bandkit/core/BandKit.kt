package uk.co.harnick.bandkit.core

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.pluginOrNull
import io.ktor.http.decodeURLQueryComponent
import io.ktor.serialization.kotlinx.json.json
import io.ktor.utils.io.core.Closeable
import uk.co.harnick.bandkit.core.BandKitException.MissingPluginException

public class BandKit(
    token: String?,
    internal val config: Config = Config(),
    internal val client: HttpClient = createDefaultClient()
) : Closeable {
    init {
        client.pluginOrNull(ContentNegotiation) ?: throw MissingPluginException(
            "ContentNegotiation plugin has not been installed to the passed HttpClient."
        )
    }

    override fun close() {
        if (client === defaultClient) client.close()
    }

    public companion object {
        public const val BASE_URL: String = "https://bandcamp.com"
        public const val LOGIN_URL: String = "$BASE_URL/login"
        public const val REGISTER_URL: String = "$BASE_URL/fansignup"
        public const val IMAGE_URL: String = "https://f4.bcbits.com/img"

        private val defaultClient: HttpClient = createDefaultClient()

        private fun createDefaultClient(): HttpClient = HttpClient {
            install(ContentNegotiation) {
                json()
            }
        }
    }

    public class Config {
        public var userAgent: String =
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/130.0.0.0 Safari/537.36"
    }

    public enum class ImageSize(
        public val apiRef: Int
    ) {
        Small(50),
        Medium(4),
        Large(5),
        Largest(10)
    }

    public enum class Encoding(
        public val apiRef: String
    ) {
        AAC("aac-hi"),
        AIFF("aiff-lossless"),
        ALAC("alac"),
        FLAC("flac"),
        MP3_320("mp3-320"),
        MP3_V0("mp3-v0"),
        OGG("vorbis"),
        WAV("wav")
    }

    public enum class SearchFilter(
        public val apiRef: String
    ) {
        None(""),
        Artists("b"),
        Items("a"),
        Tracks("t")
    }

    // Bandcamp expects a decoded token for queries
    internal val decodedToken: String? = token?.decodeURLQueryComponent()
}
