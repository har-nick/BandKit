package uk.co.harnick.bandkit.discovery.dto.fanfeed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
public class FanFeedResponse internal constructor(
    // MORE INFO NEEDED:    Unsure if this is the validity of the response or the request.
    @SerialName("ok")
    public val ok: Boolean,

    @SerialName("stories")
    public val stories: Stories,

    @SerialName("fan_info")
    public val fanInfo: JsonElement,

    @SerialName("band_info")
    public val bandInfo: Map<Long, BandInfo>,

    @SerialName("story_collectors")
    public val storyCollectors: Map<String, StoryCollector>,

    @SerialName("item_lookup")
    public val itemLookup: JsonElement
)
