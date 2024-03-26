package uk.co.harnick.bandkit.data.model

import kotlin.jvm.JvmInline
import uk.co.harnick.bandkit.data.model.ImageSize.Small
import uk.co.harnick.bandkit.data.remote.api.BandKit.Sources.IMAGES

/** A fully formed URL to fetch an explicitly sized profile image. */
@JvmInline
public value class ProfileImageUrl(public val url: String) {
    /**
     * Creates a URL to be used to fetch a user's profile image, if it exists.
     * @param id The ID of the image you want to fetch. Can be [avatarId][User.avatarId] or [bannerId][User.bannerId].
     * @param size The size of the image you wish to request.
     */
    public constructor(
        id: Long,
        size: ImageSize = Small
    ) : this(IMAGES + "/${id}_${size.apiParam}")

    /**
     * Creates a URL to be used to fetch a user's profile image, if it exists.
     * @param id The ID of the image you want to fetch. Can be [avatarId][User.avatarId] or [bannerId][User.bannerId].
     * @param size The size of the image you wish to request.
     */
    public constructor(id: Long, size: Int) : this(IMAGES + "/${id}_$size")

    /**
     * Creates a URL to be used to fetch a user's profile image, if it exists.
     * @param id The ID of the image you want to fetch. Can be [avatarId][User.avatarId] or [bannerId][User.bannerId].
     * @param size The size of the image you wish to request.
     */
    public constructor(id: Long, size: String) : this(IMAGES + "/${id}_$size")
}
