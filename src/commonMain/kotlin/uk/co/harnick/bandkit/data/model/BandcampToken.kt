package uk.co.harnick.bandkit.data.model

import kotlin.jvm.JvmInline
import kotlin.reflect.KProperty
import uk.co.harnick.bandkit.data.remote.api.BandKit

/**
 * An instance of a user's token. Used to validate [BandKit] requests.
 * @param [token] You should
 * @exception [IllegalArgumentException] If parameter [token] does not pass validation.
 */
@JvmInline
public value class BandcampToken public constructor(private val token: String) {
    init {
        // TODO: Validation
    }

    public operator fun getValue(thisRef: Any?, property: KProperty<*>): String = token
}
