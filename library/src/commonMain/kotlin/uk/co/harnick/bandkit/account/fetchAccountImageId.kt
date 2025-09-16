package uk.co.harnick.bandkit.account

import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import uk.co.harnick.bandkit.core.BandKit

/**
 * Fetches the ID of a user's profile image.
 * @property url The account URL of the target user.
 * @return The ID of the profile image, or null if an image does not exist.
 */
public suspend fun BandKit.fetchAccountImageId(
    url: String
): Long? = client.get(url)
    .bodyAsText()
    .substringAfter("<a class=\"popupImage\" href=\"https://f4.bcbits.com/img/")
    .substringBefore("_")
    .toLongOrNull()

