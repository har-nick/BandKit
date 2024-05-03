package uk.co.harnick.bandkit.data.remote.dto.items

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Suppress("UNUSED")
@Serializable
internal class CollectionItemsResponseDto(
    val items: List<ItemDto>,
    @SerialName("more_available")
    val moreItemsAvailable: Boolean,
    @SerialName("redownload_urls")
    val downloadUrls: Map<String, String>,
    val tracklists: Map<String, List<TrackDto>>,
    @SerialName("item_lookup")
    val itemLookup: Map<Long, LookupItemDto>,
    @SerialName("last_token")
    val lastToken: String,
    @SerialName("purchase_infos")
    val purchaseInfos: PurchaseInfosDto,
    val collectors: CollectorsDto
)
