package uk.co.harnick.bandkit.library.dto.item.public

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement
import uk.co.harnick.bandkit.library.dto.item.Track
import uk.co.harnick.bandkit.library.dto.item.LookupItem
import uk.co.harnick.bandkit.library.dto.item.owned.OwnedLibraryItem

@Serializable
public class PublicLibraryItemsResponse internal constructor(
    @SerialName("items")
    public val libraryItems: List<OwnedLibraryItem>,

    @SerialName("more_available")
    public val moreItemsAvailable: Boolean,

    @SerialName("tracklists")
    public val trackLists: Map<String, List<Track>>,

    @SerialName("redownload_urls")
    internal val downloadUrls: Map<String, String>,

    @SerialName("item_lookup")
    internal val lookupItems: Map<Long, LookupItem>,

    @SerialName("last_token")
    public val paginationToken: String,

    @SerialName("purchase_infos")
    public val purchaseInfos: JsonElement,

    @SerialName("collectors")
    public val collectors: JsonElement
)
