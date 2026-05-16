package uk.co.harnick.bandkit.discovery.dto.editorpicks

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal class EditorPicksRequestBody(
    @SerialName("next_cursor")
    val cursor: String?,

    @SerialName("page_size")
    val pageSize: Int
)
