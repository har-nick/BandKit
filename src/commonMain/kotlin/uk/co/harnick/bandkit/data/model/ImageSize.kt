package uk.co.harnick.bandkit.data.model

/**
 * Common values for image resolutions. See the [API documentation](<github.com/har-nick/bandcamp-api-docs/wiki/Images>) for a comprehensive list.
 * @property [apiParam] Serialized when fetching an image.
 */
public enum class ImageSize(public val apiParam: String) {
    // 100x100
    Tiny("3"),
    // 300x300
    Small("4"),
    // 700x700
    Medium("5"),
    // 1024x1024
    Large("20"),
    // 1200x1200
    XL("10")
}
