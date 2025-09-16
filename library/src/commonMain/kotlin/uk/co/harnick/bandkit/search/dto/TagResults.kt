package uk.co.harnick.bandkit.search.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public class TagResults internal constructor(
    @SerialName("matches")
    public val items: List<TagResult>,

    @SerialName("count")
    public val resultCount: Int,

    @SerialName("time_ms")
    public val timeMs: Long
)
