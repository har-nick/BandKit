package uk.co.harnick.bandkit.library.dto.summary

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public class Follows(
    @SerialName("following")
    public val following: Map<String, Boolean>
)
