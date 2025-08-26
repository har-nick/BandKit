package uk.co.harnick.bandkit.util

import uk.co.harnick.bandkit.core.BandKit
import uk.co.harnick.bandkit.core.BandKit.Companion.IMAGE_URL

public fun getAvatarImageUrl(id: Long, size: Int): String = "${IMAGE_URL}/${id}_${size}"

public fun getAvatarImageUrl(id: Long, size: BandKit.ImageSize): String =
    getAvatarImageUrl(id, size.apiRef)
