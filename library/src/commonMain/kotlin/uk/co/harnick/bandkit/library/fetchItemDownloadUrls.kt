package uk.co.harnick.bandkit.library

import com.fleeksoft.ksoup.parser.Parser
import io.ktor.client.request.accept
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.isSuccess
import io.ktor.http.userAgent
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import uk.co.harnick.bandkit.core.BandKit
import uk.co.harnick.bandkit.core.BandKit.Encoding
import uk.co.harnick.bandkit.core.BandKitException.*
import uk.co.harnick.bandkit.library.dto.download.DownloadOption

public suspend fun BandKit.fetchItemDownloadUrls(
    token: String = this.decodedToken ?: throw MissingTokenException(),
    encoding: Encoding,
    itemId: Long,
    signature: String,
    saleId: Long
): Map<Encoding, String?> {
    val baseDownloadUrl = "https://popplers5.bandcamp.com/download/album"

    val requestUrl = """
        $baseDownloadUrl
        ?enc=${encoding.apiRef}
        &id=$itemId
        &sig=$signature
        &saleId=$saleId
    """.trimIndent()

    val response = client.get(requestUrl) {
        userAgent(config.userAgent)
        accept(ContentType.Any)
        headers {
            append("identity", token)
        }
    }

    if (!response.status.isSuccess()) {
        throw ApiException("Failed to fetch download page: ${response.status}")
    }

    val rawData = response.bodyAsText()
        .substringAfter(delimiter = "downloads&quot;:", missingDelimiterValue = "")
        .substringBefore(delimiter = "},&quot;ready", missingDelimiterValue = "")
        .ifBlank { throw ApiException("Failed to locate download links in response") }

    val escapedData = Parser.unescapeEntities(rawData, inAttribute = false)

    val data: Map<String, DownloadOption> = try {
        Json.decodeFromString(escapedData)
    } catch (e: SerializationException) {
        throw ApiException("Failed to decode downloads JSON: ${e.message}")
    }

    return Encoding.entries.associateWith { enum -> data[enum.apiRef]?.url }
}
