package uk.co.harnick.bandkit.library.dto.item.owned

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement
import uk.co.harnick.bandkit.library.dto.item.LookupItem
import uk.co.harnick.bandkit.library.dto.item.Track

@Serializable
public class OwnedLibraryItemsResponse internal constructor(
    @SerialName("items")
    public val libraryItems: List<OwnedLibraryItem>,

    @SerialName("more_available")
    public val moreItemsAvailable: Boolean,

    @SerialName("tracklists")
    public val trackLists: Map<String, List<Track>>,

    @SerialName("redownload_urls")
    public val downloadUrls: Map<String, String>,

    @SerialName("item_lookup")
    public val lookupItems: Map<Long, LookupItem>,

    @SerialName("last_token")
    public val paginationToken: String,

    @SerialName("purchase_infos")
    public val purchaseInfos: JsonElement,

    @SerialName("collectors")
    public val collectors: JsonElement
)
