package data.remote.items

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CollectionItemsResponseDto(
    @SerialName("collectors")
    val collectors: CollectorsDto,
    @SerialName("item_lookup")
    val itemLookup: Map<Long, ItemLookupDto>,
    @SerialName("items")
    val items: List<ItemDto>,
    @SerialName("last_token")
    val lastToken: String,
    @SerialName("more_available")
    val moreItemsAvailable: Boolean,
    @SerialName("purchase_infos")
    val purchaseInfos: PurchaseInfosDto,
    @SerialName("redownload_urls")
    val downloadUrls: Map<String, String>,
    @SerialName("tracklists")
    val trackLists: Map<String, List<TrackDto>>
)
