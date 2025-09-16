package uk.co.harnick.bandkit.discovery.dto.fanfeed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public class QueryTimes internal constructor(
    @SerialName("followee_lookup")
    public val followeeLookup: Double,

    @SerialName("followee_purchases")
    public val followeePurchases: Double,

    @SerialName("candidate_tralbums")
    public val candidateTralbums: Double,

    @SerialName("nonfollowee_lookup")
    public val nonfolloweeLookup: Double,

    @SerialName("new_follower_lookup")
    public val newFollowerLookup: Double,

    @SerialName("artist_messages_lookup")
    public val artistMessagesLookup: Double,

    @SerialName("new_releases_lookup")
    public val newReleasesLookup: Double,

    @SerialName("fan_basic_details")
    public val fanBasicDetails: Double,

    @SerialName("fan_common_items")
    public val fanCommonItems: Double,

    @SerialName("collection_images")
    public val collectionImages: Double,

    @SerialName("band_basic_details")
    public val bandBasicDetails: Double,

    @SerialName("band_following_details")
    public val bandFollowingDetails: Double,

    @SerialName("total")
    public val total: Double
)
