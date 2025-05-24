package uk.co.harnick.bandkit.library

import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import kotlinx.serialization.json.Json
import uk.co.harnick.bandkit.core.BandKit
import uk.co.harnick.bandkit.core.BandKit.Encoding
import uk.co.harnick.bandkit.library.dto.download.DownloadOption

// This deserialization sucks. I'm not changing it.
public suspend fun BandKit.fetchItemDownloadUrls(
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

    val response = client.get(requestUrl)
    val json = response.bodyAsText()
        .substringAfter("downloads&quot;:")
        .substringBefore("},&quot;ready")
        .replace("&quot;", "&")
        .replace("&amp;", "&")

    val data: Map<String, DownloadOption> = Json.decodeFromString(json)

    return Encoding.entries.associateWith { enum -> data[enum.apiRef]?.url }
}
