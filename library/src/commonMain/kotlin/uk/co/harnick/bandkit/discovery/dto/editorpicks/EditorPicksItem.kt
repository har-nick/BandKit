package uk.co.harnick.bandkit.discovery.dto.editorpicks

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public class EditorPicksItem internal constructor(
    @SerialName("artistName")
    public val artist: String,

    // MORE INFO NEEDED: GMT for me. Is this default?
    @SerialName("date")
    public val date: String,
    
    @SerialName("description")
    public val description: String,
    
    @SerialName("genre")
    public val genre: String,

    @SerialName("imageId")
    public val artId: Long,
    
    @SerialName("itemId")
    public val itemId: Long,
    
    @SerialName("itemType")
    public val itemType: String,
    
    @SerialName("itemUrl")
    public val itemUrl: String,
    
    @SerialName("playerData")
    public val playerData: PlayerData,
    
    @SerialName("title")
    public val title: String,
    
    @SerialName("trackId")
    public val featuredTrackId: Long
)
