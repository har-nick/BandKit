package uk.co.harnick.bandkit.data.model

/**
 * A Bandcamp user profile.
 * @property [avatarId] The ID of this account's profile picture. Returns null if they do not have one. Can be passed to [ItemArtUrl] to create a fetchable image URL.
 * @property [bannerId] The ID of this account's banner image. Returns null if they do not have one. Can be passed to [ProfileImageUrl] to create a fetchable image URL.
 * @property [followerCount] The number of users following this account.
 * @property [followingCount] The number of accounts this user follows.
 * @property [nickname] A mutable name chosen by the user. Returns null if one is not set.
 * @property [username] Their account name. This is unique and immutable.
 */
public class User(
    public val id: Long,
    public val avatarId: Long?,
    public val bannerId: Long?,
    public val followerCount: Int,
    public val followingCount: Int,
    public val nickname: String?,
    public val username: String
) {
    internal constructor(pageHtml: String, id: Long, username: String) : this(
        id = id,

        avatarId = pageHtml
            .substringAfter("<a class=\"popupImage\" href=\"https://f4.bcbits.com/img/")
            .substringBefore("_")
            .toLongOrNull(),

        bannerId = pageHtml
            .substringAfter(".fan-banner")
            .substringAfter("img/")
            .substringBefore("_")
            .toLongOrNull(),

        followerCount = pageHtml
            .substringAfter("<li data-tab=\"followers\"")
            .substringAfter("<span class=\"count\">")
            .substringBefore("</span>")
            .toIntOrNull() ?: 0,

        followingCount = pageHtml
            .substringAfter("<li data-tab=\"followers\"")
            .substringAfter("<span class=\"count\">")
            .substringBefore("</span>")
            .toIntOrNull() ?: 0,

        nickname = pageHtml
            .substringAfter("<span data-bind=\"text: name\">")
            .substringBefore("</span>")
            .takeIf { it != username },

        username = username
    )
}
