package uk.co.harnick.bandkit.library

import com.fleeksoft.ksoup.parser.Parser
import io.ktor.client.request.accept
import io.ktor.client.request.cookie
import io.ktor.client.request.get
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

/**
 * Fetches all available download links for a library item.
 * @param token The token of the item's owner.
 * @param downloadGatewayUrl The gateway URL to download a library item.
 * @see [uk.co.harnick.bandkit.library.dto.item.owned.OwnedLibraryItemsResponse.downloadUrls]
 * @return A Map of download links, or null if none were found.
 */
public suspend fun BandKit.fetchItemDownloadLinks(
    downloadGatewayUrl: String,
    token: String = this.decodedToken ?: throw MissingTokenException()
): Map<Encoding, String?> {
    val gatewayResponse = client.get(downloadGatewayUrl) {
        userAgent(config.userAgent)
        accept(ContentType.Any)
        cookie("identity", token)
    }

    if (!gatewayResponse.status.isSuccess()) {
        throw ApiException("Failed to fetch download page: ${gatewayResponse.status}.")
    }

    val rawData = gatewayResponse.bodyAsText()
        .substringAfter(delimiter = "downloads&quot;:", missingDelimiterValue = "")
        .substringBefore(delimiter = ",&quot;ready", missingDelimiterValue = "")
        .ifBlank { throw ApiException("Failed to locate download links in response.") }

    val escapedData = Parser.unescapeEntities(rawData, inAttribute = false)

    val data: Map<String, DownloadOption> = try {
        Json.decodeFromString(escapedData)
    } catch (e: SerializationException) {
        throw ApiException("Failed to decode downloads JSON: ${e.message}.")
    }

    return Encoding.entries.associateWith { enum -> data[enum.apiRef]?.url }
}
