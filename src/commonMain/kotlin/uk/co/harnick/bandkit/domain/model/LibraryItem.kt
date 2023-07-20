package uk.co.harnick.bandkit.domain.model

import kotlinx.serialization.SerializationException
import uk.co.harnick.bandkit.data.remote.items.CollectionItemsResponseDto

data class LibraryItem(
    val id: Long,
    val title: String,
    val artist: String,
    val artId: Long,
    val type: ItemType,
    val trackList: List<Track>,
    val favoriteTrack: FavoriteTrack?,
)

fun CollectionItemsResponseDto.toLibraryItems(): List<LibraryItem> {
    val itemList = mutableListOf<LibraryItem>()

    this.items.forEach { itemDto ->
        val trackList = this.trackLists[itemDto.itemType + itemDto.itemId]?.map { trackDto -> trackDto.toTrack() }
        val favoriteTrack = when (itemDto.featuredTrackIsCustom) {
            true -> FavoriteTrack(itemDto.featuredTrackId, itemDto.featuredTrackTitle)
            false -> null
        }
        val item = LibraryItem(
            id = itemDto.itemId,
            title = itemDto.itemTitle,
            artist = itemDto.bandName,
            artId = itemDto.itemArtId,
            type = ItemType.entries.find { itemType ->
                itemDto.itemType == itemType.apiAcronym
            } ?: throw SerializationException("Item type could not be serialized."),
            trackList = trackList ?: listOf(),
            favoriteTrack = favoriteTrack
        )
        itemList.add(item)
    }

    return itemList
}
