package uk.co.harnick.bandkit.util

import io.ktor.client.request.headers
import io.ktor.http.CacheControl.NoCache
import io.ktor.http.CacheControl.Visibility
import io.ktor.http.HttpMessageBuilder
import io.ktor.http.header.AcceptEncoding
import io.ktor.http.header.AcceptEncoding.Companion.Deflate
import io.ktor.http.header.AcceptEncoding.Companion.Gzip
import io.ktor.http.userAgent
import uk.co.harnick.bandkit.core.BandKit

internal fun BandKit.setDefaultHeaders(builder: HttpMessageBuilder) {
    with(builder) {
        userAgent(config.userAgent)

        headers {
            append(
                name = "DNT",
                value = "1"
            )

            append(
                name = "Connection",
                value = "keep-alive"
            )

            append(
                name = "Cache-Control",
                value = NoCache(Visibility.Private).toString()
            )


            append(
                name = "Accept-Language",
                value = "en-US,en;q=0.9"
            )

            append(
                name = "Upgrade-Insecure-Requests",
                value = "1"
            )

            append(
                name = "Accept-Encoding",
                value = AcceptEncoding.mergeAcceptEncodings(Deflate, Gzip)
            )
        }
    }
}
