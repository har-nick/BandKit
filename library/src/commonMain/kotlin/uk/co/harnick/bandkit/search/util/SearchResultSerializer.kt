package uk.co.harnick.bandkit.search.util

import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import uk.co.harnick.bandkit.search.dto.ArtistResult
import uk.co.harnick.bandkit.search.dto.ItemResult
import uk.co.harnick.bandkit.search.dto.SearchResult
import uk.co.harnick.bandkit.search.dto.TrackResult

internal object SearchResultSerializer : JsonContentPolymorphicSerializer<SearchResult>(
    baseClass = SearchResult::class
) {
    override fun selectDeserializer(element: JsonElement): DeserializationStrategy<SearchResult> {
        return when (element.jsonObject["type"]?.jsonPrimitive?.content) {
            "b" -> ArtistResult.serializer()
            "a" -> ItemResult.serializer()
            "t" -> TrackResult.serializer()
            else -> throw SerializationException("Unknown type: ${element.jsonObject["type"]}")
        }
    }
}
