package uk.co.harnick.bandkit.data.model

import kotlinx.serialization.Serializable
import uk.co.harnick.bandkit.data.remote.dto.followee.band.ArtistFolloweeDto

@Serializable
public data class ArtistFollowee internal constructor(
    public val artistId: Long,
    public val avatarId: Long?,
    public override val dateFollowed: String,
    public override val location: String?,
    public override val nickname: String,
    public override val username: String
) : Followee

internal fun ArtistFolloweeDto.toArtistFollowee(): ArtistFollowee =
    ArtistFollowee(
        artistId = artistId,
        avatarId = avatarId,
        dateFollowed = dateFollowed,
        location = location,
        nickname = nickname,
        username = urlHints.subdomain
    )
