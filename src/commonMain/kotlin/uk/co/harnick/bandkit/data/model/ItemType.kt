package uk.co.harnick.bandkit.data.model

/** The relevant types an instance of [LibraryItem] can represent. */
public enum class ItemType {
    /** What you'd expect as a "standard" album. */
    Album,
    /** An instance of [Album], with details for extra content, typically merchandise. */
    Package,
    /** An instance where its playable contents is a single track. */
    Track;

    internal companion object {
        /**
         * Parses a serialized representation of [ItemType].
         * @return An instance of [ItemType].
         * @throws [NoSuchElementException] When the passed [input] cannot be parsed.
         */
        internal fun parse(input: String): ItemType {
            return when (input.first().lowercase()) {
                "a" -> Album
                "p" -> Package
                "t" -> Track
                else -> throw NoSuchElementException("Input $input could not be parsed to an instance of ItemType.")
            }
        }
    }
}
