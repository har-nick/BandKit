package uk.co.harnick.bandkit.discovery.dto.fanfeed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public class StoryCollector internal constructor(
    @SerialName("thumbs")
    public val thumbnails: List<Thumbnail>,

    @SerialName("reviews")
    public val reviews: List<Review>,

    @SerialName("more_thumbs_available")
    public val moreThumbnailsAvailable: Boolean,

    @SerialName("more_reviews_available")
    public val moreReviewsAvailable: Boolean,

    @SerialName("shown_reviews")
    public val shownReviews: List<Review>,

    @SerialName("shown_thumbs")
    public val shownThumbs: List<Thumbnail>
)
