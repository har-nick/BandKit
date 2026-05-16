package uk.co.harnick.bandkit.discovery

import io.ktor.client.request.setBody
import io.ktor.http.ContentType.Application.Json
import io.ktor.http.HttpMethod.Companion.Post
import uk.co.harnick.bandkit.core.BandKit
import uk.co.harnick.bandkit.core.BandKit.Companion.BASE_URL
import uk.co.harnick.bandkit.core.dto.ApiError
import uk.co.harnick.bandkit.discovery.dto.editorpicks.EditorPicksRequestBody
import uk.co.harnick.bandkit.discovery.dto.editorpicks.EditorPicksResponse
import uk.co.harnick.bandkit.util.fetchApiResponse

public suspend fun BandKit.fetchEditorPicks(
    count: Int,
    cursor: String?
): EditorPicksResponse {
    val editorPicksUrl = "$BASE_URL/api/homepage_api/1/notable_tralbums_list"
    val requestBody = EditorPicksRequestBody(cursor, count)

    return fetchApiResponse<EditorPicksResponse, ApiError>(
        url = editorPicksUrl,
        httpMethod = Post,
        contentType = Json,
        config = { setBody(requestBody) }
    )
}
