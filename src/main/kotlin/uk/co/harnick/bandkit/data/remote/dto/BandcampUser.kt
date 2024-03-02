package uk.co.harnick.bandkit.data.remote.dto

public class BandcampUser(pageHtml: String, public val username: String) {
    public val avatarId: Long? = pageHtml
        .substringAfter("<a class=\"popupImage\" href=\"https://f4.bcbits.com/img/")
        .substringBefore("_")
        .toLongOrNull()

    public val bannerId: Long? = pageHtml
        .substringAfter(".fan-banner")
        .substringAfter("img/")
        .substringBefore("_")
        .toLongOrNull()

    public val followerCount: Int = pageHtml
        .substringAfter("<li data-tab=\"followers\"")
        .substringAfter("<span class=\"count\">")
        .substringBefore("</span>")
        .toIntOrNull() ?: 0

    public val followingCount: Int = pageHtml
        .substringAfter("<li data-tab=\"following\"")
        .substringAfter("<span class=\"count\">")
        .substringBefore("</span>")
        .toIntOrNull() ?: 0

    public val nickname: String = pageHtml
        .substringAfter("<span data-bind=\"text: name\">")
        .substringBefore("</span>")
}
