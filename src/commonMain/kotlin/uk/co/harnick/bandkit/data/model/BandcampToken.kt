package uk.co.harnick.bandkit.data.model

import kotlinx.serialization.Serializable
import uk.co.harnick.bandkit.data.remote.api.BandKit
import kotlin.jvm.JvmInline

// TODO: VALIDATION
/**
 * An instance of a user's token. Used to validate [BandKit] requests.
 * @param [token] You should
 * @exception [IllegalArgumentException] If parameter [token] does not pass validation.
 */
@Serializable
@JvmInline
public value class BandcampToken(public val token: String) {
    private fun tokenIsUrlEncoded(token: String): Boolean {
        val regex = "^[A-Za-z0-9%+/=]+$".toRegex()
        return token.matches(regex)
    }

    init {
        require(tokenIsUrlEncoded(token)) { "Token is not URL-Encoded" }
    }
}
