package uk.co.harnick.bandkit.search.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public class GenreResult internal constructor(
    @SerialName("genre")
    public val genre: String,

    @SerialName("subgenre")
    public val subgenre: String?
)
