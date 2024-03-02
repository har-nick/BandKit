package uk.co.harnick.bandkit.data.remote.dto.summary

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public class CollectionSummaryDto(
    @SerialName("fan_id")
    public val userId: Long,
    @SerialName("follows")
    public val follows: FollowsDto,
    @SerialName("tralbum_lookup")
    public val albums: Map<String, TrAlbumLookupDto>,
    @SerialName("url")
    public val userUrl: String,
    @SerialName("username")
    public val username: String
)
