package uk.co.harnick.bandkit.core

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.pluginOrNull
import uk.co.harnick.bandkit.core.BandKitException.MissingPluginException

public class BandKit(internal val client: HttpClient) {
    init {
        client.pluginOrNull(BandKitPlugin) ?: throw MissingPluginException(
            "BandKit plugin has not been installed to the passed HttpClient."
        )

        client.pluginOrNull(ContentNegotiation) ?: throw MissingPluginException(
            "ContentNegotiation plugin has not been installed to the passed HttpClient."
        )
    }

    public companion object {
        public const val BASE_URL: String = "https://bandcamp.com"
        internal val hosts = listOf("bandcamp.com", "popplers5.bandcamp.com")
    }

    public class Config {
        public var token: String? = null
        public var userAgent: String =
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/130.0.0.0 Safari/537.36"
    }

    public enum class ImageSize(public val apiRef: Int) {
        Small(50),
        Medium(4),
        Large(5),
        Largest(10)
    }

    public enum class Encoding(public val apiRef: String) {
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
}
