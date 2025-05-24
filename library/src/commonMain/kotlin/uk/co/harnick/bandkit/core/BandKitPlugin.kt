package uk.co.harnick.bandkit.core

import io.ktor.client.plugins.api.ClientPlugin
import io.ktor.client.plugins.api.createClientPlugin
import io.ktor.http.URLProtocol.Companion.HTTPS
import io.ktor.http.userAgent
import uk.co.harnick.bandkit.core.BandKit.Companion.hosts
import uk.co.harnick.bandkit.core.BandKit.Config
import uk.co.harnick.bandkit.core.BandKitException.MissingTokenException
import uk.co.harnick.bandkit.core.BandKitException.SslRequiredException

public val BandKitPlugin: ClientPlugin<Config> = createClientPlugin("BandKitPlugin", ::Config) {
    val userAgent = pluginConfig.userAgent
    val token = pluginConfig.token

    onRequest { request, _ ->
        if (!hosts.contains(request.url.host)) return@onRequest
        if (request.url.protocol != HTTPS) throw SslRequiredException("${request.url}")
        if (token.isNullOrBlank()) throw MissingTokenException

        request.userAgent(userAgent)
        request.headers.append("Cookie", "identity=$token")
    }
}
