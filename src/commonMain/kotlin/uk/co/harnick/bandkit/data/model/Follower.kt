package uk.co.harnick.bandkit.data.model

import kotlinx.serialization.Serializable
import uk.co.harnick.bandkit.data.remote.dto.follower.FollowerDto

@Serializable
public data class Follower internal constructor(
    public val id: Long,
    public val avatarId: Long?,
    public val displayName: String,
    public val location: String?,
    public val followDate: String,
    public val isFollowed: Boolean,
    public val username: String
)

internal fun FollowerDto.toFollower() = Follower(
    id = fanId ?: artistId!!,
    avatarId = avatarId,
    displayName = displayName,
    followDate = dateFollowed,
    location = location,
    isFollowed = isFollowed,
    username = url.substringAfterLast("/")
)
