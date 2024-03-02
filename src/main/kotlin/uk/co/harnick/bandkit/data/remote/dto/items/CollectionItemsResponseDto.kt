package uk.co.harnick.bandkit.data.remote.dto.items

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public class CollectionItemsResponseDto(
    public val items: List<ItemDto>,
    @SerialName("more_available")
    public val moreItemsAvailable: Boolean,
    public val tracklists: Map<String, List<TrackDto>>,
    @SerialName("redownload_urls")
    public val downloadUrls: Map<String, String>,
    @SerialName("item_lookup")
    public val itemLookup: Map<Long, LookupItemDto>,
    @SerialName("last_token")
    public val lastToken: String,
    @SerialName("purchase_infos")
    public val purchaseInfos: PurchaseInfosDto,
    public val collectors: CollectorsDto
)
