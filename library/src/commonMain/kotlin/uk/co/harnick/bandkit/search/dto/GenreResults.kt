package uk.co.harnick.bandkit.search.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public class GenreResults internal constructor(
    @SerialName("match")
    public val items: List<GenreResult>
)
