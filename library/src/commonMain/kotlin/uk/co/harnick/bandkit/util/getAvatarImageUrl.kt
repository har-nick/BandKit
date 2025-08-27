package uk.co.harnick.bandkit.util

import uk.co.harnick.bandkit.core.BandKit
import uk.co.harnick.bandkit.core.BandKit.Companion.IMAGE_URL

/**
 * Creates a URL for a user's avatar image.
 * @param id The user's ID.
 * @param size An integer representing the API reference for the image size.
 * @return A direct fetchable link to the item's art.
 */
public fun getAvatarImageUrl(id: Long, size: Int): String = "${IMAGE_URL}/${id}_${size}"

/**
 * Creates a URL for a user's avatar image.
 * @param id The user's ID.
 * @param size An instance of [BandKit.ImageSize] representing the API reference for the image size.
 * @return A direct fetchable link to the item's art.
 */
public fun getAvatarImageUrl(id: Long, size: BandKit.ImageSize): String =
    getAvatarImageUrl(id, size.apiRef)
