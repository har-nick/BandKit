package uk.co.harnick.bandkit.discovery.dto.fanfeed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import uk.co.harnick.bandkit.discovery.util.BooleanAsIntSerializer

@Serializable
public class BandInfo internal constructor(
    @SerialName("band_id")
    public val bandId: Long,

    @SerialName("name")
    public val artistName: String,

    @SerialName("image_id")
    public val artistImageId: Long,

    @SerialName("genre_id")
    public val genreId: Long,

    @SerialName("latest_art_id")
    public val latestArtId: Long,

    // MORE INFO NEEDED:    Is this an encoded boolean (do not index), or an index (number of index)?
    @SerialName("no_index")
    public val noIndex: Int,

    @Serializable(with = BooleanAsIntSerializer::class)
    @SerialName("followed")
    public val userIsFollowing: Boolean,
)
