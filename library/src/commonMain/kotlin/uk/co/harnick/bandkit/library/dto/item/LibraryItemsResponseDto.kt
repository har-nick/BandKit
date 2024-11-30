package uk.co.harnick.bandkit.library.dto.item

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import uk.co.harnick.bandkit.util.UnknownType

@Serializable
public class LibraryItemsResponseDto private constructor(
    @SerialName("items")
    public val libraryItems: List<LibraryItemDto>,

    @SerialName("more_available")
    public val moreItemsAvailable: Boolean,

    @SerialName("tracklists")
    public val trackLists: Map<String, List<TrackDto>>,

    @SerialName("redownload_urls")
    public val downloadUrls: Map<String, String>,

    @SerialName("item_lookup")
    public val lookupItems: Map<Long, LookupItemDto>,

    @SerialName("last_token")
    public val paginationToken: String,

    @SerialName("purchase_infos")
    public val purchaseInfos: UnknownType,

    @SerialName("collectors")
    public val collectors: UnknownType,
)
