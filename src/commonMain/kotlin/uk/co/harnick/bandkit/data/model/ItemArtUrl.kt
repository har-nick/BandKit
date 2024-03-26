package uk.co.harnick.bandkit.data.model

import kotlin.jvm.JvmInline
import uk.co.harnick.bandkit.data.model.ImageSize.Small
import uk.co.harnick.bandkit.data.remote.api.BandKit.Sources.IMAGES

/** A fully formed URL to fetch an explicitly sized album art. */
@JvmInline
public value class ItemArtUrl(public val url: String) {
    /**
     * Creates a URL to be used to fetch album art.
     * @param id The ID of the image you want to fetch. Can be found in [LibraryItem] or [Track].
     * @param size The size of the image you wish to request.
     */
    public constructor(
        id: Long,
        size: ImageSize = Small
    ) : this(IMAGES + "/a${id}_${size.apiParam}")

    /**
     * Creates a URL to be used to fetch album art.
     * @param id The ID of the image you want to fetch. Can be found in [LibraryItem] or [Track].
     * @param size The size of the image you wish to request.
     */
    public constructor(id: Long, size: Int) : this(IMAGES + "/a${id}_$size")

    /**
     * Creates a URL to be used to fetch album art.
     * @param id The ID of the image you want to fetch. Can be found in [LibraryItem] or [Track].
     * @param size The size of the image you wish to request.
     */
    public constructor(id: Long, size: String) : this(IMAGES + "/a${id}_$size")
}
