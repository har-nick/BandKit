package uk.co.harnick.bandkit.data.model

import kotlinx.serialization.Serializable
import uk.co.harnick.bandkit.data.remote.dto.followee.fan.FanFolloweeDto
import uk.co.harnick.bandkit.util.toISO8601

@Serializable
public data class FanFollowee internal constructor(
    public val avatarId: Long?,
    override val dateFollowed: String,
    public val fanId: Long,
    public val isFollowing: Boolean,
    override val location: String?,
    public override val nickname: String,
    override val username: String
) : Followee

internal fun FanFolloweeDto.toFanFollowee(): FanFollowee =
    FanFollowee(
        avatarId = avatarId,
        dateFollowed = dateFollowed.toISO8601(),
        fanId = fanId,
        isFollowing = isFollowing,
        location = location,
        nickname = nickname,
        username = url.substringAfterLast("/")
    )
