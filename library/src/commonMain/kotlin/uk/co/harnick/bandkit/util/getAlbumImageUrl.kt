package uk.co.harnick.bandkit.util

import uk.co.harnick.bandkit.core.BandKit
import uk.co.harnick.bandkit.core.BandKit.Companion.IMAGE_URL

/**
 * Creates a URL for a library item's art image.
 * @param id The item's art ID.
 * @param size An integer representing the API reference for the image size.
 * @return A direct fetchable link to the item's art.
 */
public fun getAlbumImageUrl(id: Long, size: Int): String = "${IMAGE_URL}/a${id}_${size}"

/**
 * Creates a URL for a library item's art image.
 * @param id The item's art ID.
 * @param size An instance of [BandKit.ImageSize] representing the API reference for the image size.
 * @return A direct fetchable link to the item's art.
 */
public fun getAlbumImageUrl(id: Long, size: BandKit.ImageSize): String =
    getAlbumImageUrl(id, size.apiRef)
