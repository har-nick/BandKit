package uk.co.harnick.bandkit.core

import io.ktor.client.plugins.api.ClientPlugin
import io.ktor.client.plugins.api.createClientPlugin
import io.ktor.http.URLProtocol.Companion.HTTPS
import io.ktor.http.userAgent
import uk.co.harnick.bandkit.core.BandKitException.SslRequiredException

public val BandKitPlugin: ClientPlugin<BandKitPluginConfig> =
    createClientPlugin("BandKitPlugin", ::BandKitPluginConfig) {
        val ua = pluginConfig.userAgent
        val token = pluginConfig.token

        onRequest { request, _ ->
            if (request.url.protocol != HTTPS) throw SslRequiredException("${request.url}")
            request.userAgent(ua)
            request.headers.append("Cookie", "identity=$token")
        }
    }
