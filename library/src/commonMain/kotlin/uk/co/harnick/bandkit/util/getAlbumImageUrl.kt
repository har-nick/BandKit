package uk.co.harnick.bandkit.util

import uk.co.harnick.bandkit.core.BandKit
import uk.co.harnick.bandkit.core.BandKit.Companion.IMAGE_URL

public fun getAlbumImageUrl(id: Long, size: Int): String = "${IMAGE_URL}/a${id}_${size}"

public fun getAlbumImageUrl(id: Long, size: BandKit.ImageSize): String =
    getAlbumImageUrl(id, size.apiRef)
