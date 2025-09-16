package uk.co.harnick.bandkit.search.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public class ItemResult internal constructor(
    @SerialName("type")
    public val type: String,

    @SerialName("id")
    public val id: Long,

    @SerialName("art_id")
    public val artId: Long?,

    @SerialName("img_id")
    public val artistImageId: Long?,

    @SerialName("name")
    public val name: String,

    @SerialName("band_id")
    public val artistId: Long,

    @SerialName("band_name")
    public val artistName: String,

    @SerialName("item_url_root")
    public val artistUrl: String,

    @SerialName("item_url_path")
    public val itemUrlPath: String,

    @SerialName("img")
    public val artUrl: String,

    @SerialName("tag_names")
    public val tagNames: List<String>?,

    @SerialName("stat_params")
    public val statParams: String
) : SearchResult
