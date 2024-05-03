package uk.co.harnick.bandkit.data.model

import kotlinx.serialization.Serializable

/**
 * A Bandcamp user profile.
 * @property [avatarId] The ID of this account's profile picture. Returns null if they do not have one.
 * @property [bannerId] The ID of this account's banner image. Returns null if they do not have one.
 * @property [displayName] A mutable name chosen by the user. Returns null if one is not set.
 * @property [username] Their account name. This is unique and immutable.
 */
@Serializable
public open class User internal constructor(
    public open val id: Long,
    public open val avatarId: Long?,
    public val bannerId: Long?,
    public open val displayName: String,
    public open val username: String,
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

        displayName = pageHtml
            .substringAfter("<span data-bind=\"text: name\">")
            .substringBefore("</span>"),

        username = username
    )
}
