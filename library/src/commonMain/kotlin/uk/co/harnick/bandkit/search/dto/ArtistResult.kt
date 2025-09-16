package uk.co.harnick.bandkit.search.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public class ArtistResult internal constructor(
    @SerialName("type")
    public val type: String,

    @SerialName("id")
    public val id: Long,

    @SerialName("art_id")
    public val itemArtId: Long?,

    @SerialName("img_id")
    public val avatarImageId: Long?,

    @SerialName("name")
    public val name: String,

    @SerialName("item_url_root")
    public val artistUrl: String,

    @SerialName("location")
    public val location: String,

    @SerialName("is_label")
    public val isLabel: Boolean,

    @SerialName("tag_names")
    public val tagNames: List<String>,

    @SerialName("img")
    public val avatarUrl: String,

    @SerialName("genre_name")
    public val genreName: String,

    @SerialName("stat_params")
    public val statParams: String,

    @SerialName("following")
    public val isFollowing: Boolean
) : SearchResult
