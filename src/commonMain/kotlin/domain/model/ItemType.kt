package domain.model

enum class ItemType(val apiName: String, val apiAcronym: String, val label: String) {
    Track("track", "t", "Track"),
    Album("album", "a", "Album"),
    Package("package", "p", "Package")
}
