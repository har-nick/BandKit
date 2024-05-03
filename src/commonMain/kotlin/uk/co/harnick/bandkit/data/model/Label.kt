package uk.co.harnick.bandkit.data.model

import kotlinx.serialization.Serializable

/**
 * An instance of a library item's publishing label.
 * @param [id] The unique ID for this label.
 * @param [name] The name of the label.
 */
@Serializable
public data class Label internal constructor(
    public val id: Long,
    public val name: String
)
