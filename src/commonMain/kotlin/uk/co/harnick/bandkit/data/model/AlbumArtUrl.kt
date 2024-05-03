package uk.co.harnick.bandkit.data.model

import uk.co.harnick.bandkit.data.model.ImageSize.Small
import uk.co.harnick.bandkit.data.remote.api.BandKit.Sources.IMAGES

/**
 * Creates a functional url to request an [item's][LibraryItem] album art.
 * @param [id] The ID of the album art. See [artId][LibraryItem.artId].
 * @param [size] The size of the image you wish to request. See [ImageSize] for sane pointers.
 */
public class AlbumArtUrl(private val id: Long, private val size: String = Small.apiParam) {
    public constructor(id: Long, size: ImageSize = Small) : this(id, size.apiParam)
    public constructor(id: Long) : this(id, Small)
    public constructor(id: Long, size: Int) : this(id, "$size")

    override fun toString(): String = "$IMAGES/a${id}_${size}.jpg"
}
