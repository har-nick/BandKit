package uk.co.harnick.bandkit.data.model

import kotlin.jvm.JvmInline
import uk.co.harnick.bandkit.data.remote.api.BandKit

// TODO: VALIDATION
/**
 * An instance of a user's token. Used to validate [BandKit] requests.
 * @param [token] You should
 * @exception [IllegalArgumentException] If parameter [token] does not pass validation.
 */
@JvmInline
public value class BandcampToken(public val token: String)
