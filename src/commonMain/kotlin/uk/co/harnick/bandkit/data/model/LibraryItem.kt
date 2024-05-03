package uk.co.harnick.bandkit.data.model

import kotlinx.serialization.Serializable
import uk.co.harnick.bandkit.data.remote.dto.items.CollectionItemsResponseDto
import uk.co.harnick.bandkit.data.remote.dto.items.ItemDto
import uk.co.harnick.bandkit.util.toISO8601

/**
 * An instance of a Bandcamp library item.
 * @param [artId] The ID of the album art.
 * @param [artist] The performing artist or band for this album.
 * @param [dateTimeAdded] An ISO 8601 string representing the date and time this item was added to the library.
 * @param [dateTimePurchased] An ISO 8601 string representing the date and time this item was purchased.
 * @param [downloadUrl] A webpage URL prompting to download the item.
 * @param [favoriteTrackId] The ID of the user's favorite track. Returns null if one is not set.
 * @param [id] The unique ID for this item.
 * @param [label] The publishing label for this item. Returns null if one doesn't exist.
 * @param [title] The title of this item. If [type] is [Track][ItemType.Track] it will be the track title instead.
 * @param [tracklist] A list of [Track] instances for this item. Contains a single instance if [type] is [Track][ItemType.Track].
 * @param [type] The type of item this instance represents.
 */
@Serializable
public data class LibraryItem internal constructor(
    public val artId: Long,
    public val artist: Artist,
    public val dateTimeAdded: String,
    public val dateTimePurchased: String,
    public val dateTimeReleased: String,
    public val downloadUrl: String?,
    public val favoriteTrackId: Long?,
    public val id: Long,
    public val label: Label?,
    public val title: String,
    public val tracklist: List<Track>,
    public val type: ItemType,
)

private fun ItemDto.toItem(downloadUrl: String?, tracklist: List<Track>): LibraryItem {
    val artist = Artist(artistImageId, artistLocation, artistName, artistUrl)
    val favoriteTrack = if (favoriteTrackIsCustom) favoriteTrackId else null
    val itemType = ItemType.parse(itemType)

    return LibraryItem(
        artId = artId,
        artist = artist,
        dateTimeAdded = dateTimeAdded.toISO8601(),
        dateTimePurchased = dateTimePurchased.toISO8601(),
        dateTimeReleased = dateTimePurchased.toISO8601(),
        downloadUrl = downloadUrl,
        favoriteTrackId = favoriteTrack,
        id = itemId,
        label = labelId?.let { Label(it, labelName!!) },
        title = title,
        tracklist = tracklist,
        type = itemType
    )
}

internal fun CollectionItemsResponseDto.toLibraryItems(): List<LibraryItem> {
    val itemList = mutableListOf<LibraryItem>()

    items.forEach { itemDto ->
        val type = itemDto.itemType.first().lowercase()
        val downloadUrl = downloadUrls.getValue("p${itemDto.saleId}")
        val tracklist = tracklists
            .getValue("${type}${itemDto.itemId}")
            .map { it.toTrack(itemDto.artId) }
        val mappedItem = itemDto.toItem(downloadUrl, tracklist)

        itemList.add(mappedItem)
    }

    return itemList
}
