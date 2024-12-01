package uk.co.harnick.bandkit.library

import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import kotlinx.serialization.json.Json
import uk.co.harnick.bandkit.core.BandKit
import uk.co.harnick.bandkit.library.dto.download.DownloadOptionDto
import uk.co.harnick.bandkit.util.Encoding

public suspend fun BandKit.fetchItemDownloadUrls(
    encoding: Encoding,
    itemId: Long,
    signature: String,
    saleId: Long
): List<DownloadOptionDto> {
    val requestUrl = """
        ${BandKit.Library.DOWNLOADING}
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

    val data: Map<String, DownloadOptionDto> = Json.decodeFromString(json)
    return data.values.toList()
}
