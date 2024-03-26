package uk.co.harnick.bandkit.data.model

/**
 * A Bandcamp artist or band.
 * @property [imageId] The ID of the artist's image or art. Can be passed to [ItemArtUrl] to create a fetchable image URL.
 * @property [location] Where the artist is from or currently resides. Returns null if not available.
 * @property [name] The name of the artist.
 * @property [url] The URL of the artist's website. Unless custom, this will lead to their Bandcamp page.
 */
public class Artist(
    public val imageId: Long?,
    public val location: String?,
    public val name: String,
    public val url: String
)
