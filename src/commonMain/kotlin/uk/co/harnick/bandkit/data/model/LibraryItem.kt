package uk.co.harnick.bandkit.data.model

import uk.co.harnick.bandkit.data.remote.dto.items.CollectionItemsResponseDto
import uk.co.harnick.bandkit.data.remote.dto.items.ItemDto

/**
 * An instance of a Bandcamp library item.
 * @param [artId] The ID of the album art. Can be passed to [ItemArtUrl] to create a fetchable image URL.
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
public class LibraryItem(
    public val artId: Long,
    public val artist: Artist,
    public val dateTimeAdded: String,
    public val dateTimePurchased: String,
    public val downloadUrl: String?,
    public val favoriteTrackId: Long?,
    public val id: Long,
    public val label: Label?,
    public val title: String,
    public val tracklist: List<Track>,
    public val type: ItemType,
)

private fun String.toISO8601(): String {
    val parts = split(" ")
    val months =
        listOf("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec")
    val day = parts[0].toInt()
    val month = (months.indexOf(parts[1]) + 1).toString().padStart(2, '0')
    val year = parts[2]
    val timeParts = parts[3].split(":")
    val hour = timeParts[0]
    val minute = timeParts[1]
    val second = timeParts[2].substring(0, 2)

    return "$year-$month-${day.toString().padStart(2, '0')}T${hour}:${minute}:${second}Z"
}

private fun ItemDto.toItem(downloadUrl: String?, tracklist: List<Track>): LibraryItem {
    val artist = Artist(bandImageId, bandLocation, bandName, bandUrl)
    val dateTimeAdded = dateTimeAdded.toISO8601()
    val dateTimePurchased = dateTimePurchased.toISO8601()
    val favoriteTrack = if (featuredTrackIsCustom) featuredTrackId else null
    val itemType = ItemType.parse(type)

    return LibraryItem(
        artId = artId,
        artist = artist,
        dateTimeAdded = dateTimeAdded,
        dateTimePurchased = dateTimePurchased,
        downloadUrl = downloadUrl,
        favoriteTrackId = favoriteTrack,
        id = id,
        label = labelId?.let { Label(it, labelName!!) },
        title = title,
        tracklist = tracklist,
        type = itemType
    )
}

internal fun CollectionItemsResponseDto.toLibraryData(): List<LibraryItem> {
    val itemList = mutableListOf<LibraryItem>()

    items.forEach { itemDto ->
        val downloadUrl = downloadUrls.getValue("p${itemDto.saleId}")
        val tracklist = tracklists
            .getValue("${itemDto.saleType}${itemDto.saleId}")
            .map { it.toTrack(itemDto.artId) }
        val mappedItem = itemDto.toItem(downloadUrl, tracklist)

        itemList.add(mappedItem)
    }

    return itemList
}
