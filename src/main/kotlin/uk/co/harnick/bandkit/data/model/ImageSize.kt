package uk.co.harnick.bandkit.data.model

// For a comprehensive list of resolutions and API representations, see:
// https://github.com/har-nick/bandcamp-api-docs/wiki/Images
public enum class ImageSize(internal val apiParam: String) {
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
