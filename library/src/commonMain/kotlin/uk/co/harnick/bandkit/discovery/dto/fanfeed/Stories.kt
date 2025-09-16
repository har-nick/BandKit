package uk.co.harnick.bandkit.discovery.dto.fanfeed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
public class Stories internal constructor(
    @SerialName("entries")
    public val entries: List<Story>,

    @SerialName("oldest_story_date")
    public val oldestStoryDate: Long,

    @SerialName("newest_story_date")
    public val newestStoryDate: Long,

    @SerialName("track_list")
    public val trackList: List<Track>,

    @SerialName("query_times")
    public val queryTimes: QueryTimes,

    @SerialName("feed_timestamp")
    public val feedTimestamp: JsonElement
)
