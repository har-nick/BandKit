package uk.co.harnick.bandkit.domain.model

data class BandcampUser(
    val username: String,
    val nickname: String?,
    val avatarId: Long?,
    val bannerId: Long?,
    val followers: Int,
    val following: Int
)
