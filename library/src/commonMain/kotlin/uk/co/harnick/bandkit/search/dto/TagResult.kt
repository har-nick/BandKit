package uk.co.harnick.bandkit.search.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public class TagResult internal constructor(
    @SerialName("display_tag_id")
    public val tagId: Long,

    @SerialName("score")
    public val score: Long,

    @SerialName("count")
    public val count: Int,

    @SerialName("norm_name")
    public val name: String,

    @SerialName("display_name")
    public val displayName: String
)
