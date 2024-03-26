package uk.co.harnick.bandkit.data.remote.dto.summary

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal class CollectionSummaryDto(
    @SerialName("fan_id")
    val userId: Long,
    @SerialName("follows")
    val follows: FollowsDto,
    @SerialName("tralbum_lookup")
    val albums: Map<String, TrAlbumLookupDto>,
    @SerialName("url")
    val userUrl: String,
    @SerialName("username")
    val username: String
)
