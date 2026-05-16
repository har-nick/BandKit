package uk.co.harnick.bandkit.discovery.dto.editorpicks

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public class EditorPicksResponse internal constructor(
    @SerialName("items")
    public val items: List<EditorPicksItem>,

    // NOTE: Does not seem to coincide with album or artist IDs, in contravention to other cursors.
    @SerialName("nextCursor")
    public val cursor: String
)
