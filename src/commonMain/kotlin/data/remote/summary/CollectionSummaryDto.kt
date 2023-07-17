package data.remote.summary

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CollectionSummaryDto(
    @SerialName("fan_id")
    val userId: Long,
    @SerialName("follows")
    val follows: FollowsDto,
    @SerialName("tralbum_lookup")
    val trAlbumLookupList: Map<String, TrAlbumLookupDto>,
    @SerialName("url")
    val userUrl: String,
    @SerialName("username")
    val username: String
)
