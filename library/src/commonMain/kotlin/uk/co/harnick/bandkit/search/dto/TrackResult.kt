package uk.co.harnick.bandkit.search.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public class TrackResult internal constructor(
    @SerialName("type")
    public val type: String,

    @SerialName("id")
    public val id: Long,

    @SerialName("art_id")
    public val artId: Long,

    @SerialName("img_id")
    public val artistAvatarId: Long?,

    @SerialName("name")
    public val name: String,

    @SerialName("band_id")
    public val artistId: Long,

    @SerialName("band_name")
    public val artistName: String,

    @SerialName("album_name")
    public val itemName: String,

    @SerialName("item_url_root")
    public val artistUrl: String,

    @SerialName("item_url_path")
    public val itemUrl: String,

    @SerialName("img")
    public val itemArtUrl: String,

    @SerialName("album_id")
    public val itemId: Long,

    @SerialName("stat_params")
    public val statParams: String
) : SearchResult
