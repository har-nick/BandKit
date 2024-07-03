package uk.co.harnick.bandkit.data.model

import uk.co.harnick.bandkit.data.model.ImageSize.Small
import uk.co.harnick.bandkit.data.remote.api.BandKit

/**
 * Creates a functional url to request a [user's][User] profile image.
 * @param [id] The ID of the image. See [avatarId][User.avatarId].
 * @param [size] The size of the image you wish to request. See [ImageSize] for sane pointers.
 */
public class ProfileImageUrl(private val id: Long, private val size: String = Small.apiParam) {
    public constructor(id: Long, size: ImageSize = Small) : this(id, size.apiParam)
    public constructor(id: Long) : this(id, Small)
    public constructor(id: Long, size: Int) : this(id, "$size")

    override fun toString(): String = "${BandKit.Sources.IMAGES}/${id}_${size}.jpg"
}
