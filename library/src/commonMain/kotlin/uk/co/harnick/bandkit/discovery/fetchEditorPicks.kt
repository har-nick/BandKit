package uk.co.harnick.bandkit.discovery

import io.ktor.client.request.setBody
import io.ktor.http.ContentType.Application.Json
import io.ktor.http.HttpMethod.Companion.Post
import kotlinx.serialization.json.Json as JsonSerializer
import uk.co.harnick.bandkit.core.BandKit
import uk.co.harnick.bandkit.core.BandKit.Companion.BASE_URL
import uk.co.harnick.bandkit.core.dto.ApiError
import uk.co.harnick.bandkit.discovery.dto.editorpicks.EditorPicksError
import uk.co.harnick.bandkit.discovery.dto.editorpicks.NotableIds
import uk.co.harnick.bandkit.discovery.dto.editorpicks.EditorPicksResponse
import uk.co.harnick.bandkit.util.fetchApiResponse

public suspend fun BandKit.fetchEditorPicks(): EditorPicksResponse {
    val notablesListUrl = "$BASE_URL/api/homepage_api/1/notable_tralbums_list"
    val notablesList = fetchApiResponse<List<NotableIds>, ApiError>(
        url = notablesListUrl,
        httpMethod = Post,
        contentType = Json
    )


    val notableItemsUrl = "$BASE_URL/api/homepage_api/1/notable_tralbums_data"
    val body = JsonSerializer.encodeToString(notablesList)

    return fetchApiResponse<EditorPicksResponse, EditorPicksError>(
        url = notableItemsUrl,
        httpMethod = Post,
        contentType = Json,
        config = { setBody(body) }
    )
}
