package uk.co.harnick.bandkit.discovery

import io.ktor.http.ContentType.Application.Json
import io.ktor.http.HttpMethod
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.element
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.jsonObject
import uk.co.harnick.bandkit.core.BandKit
import uk.co.harnick.bandkit.core.BandKit.Companion.BASE_URL
import uk.co.harnick.bandkit.core.dto.ApiError
import uk.co.harnick.bandkit.discovery.dto.AlbumOfTheDay
import uk.co.harnick.bandkit.util.fetchApiResponse

/**
 * Fetches the current album of the day.
 * @return An instance of [AlbumOfTheDay].
 */
public suspend fun BandKit.fetchAlbumOfTheDay(
): AlbumOfTheDay {
    val url = "$BASE_URL/api/homepage_api/1/get_aotd"

    return fetchApiResponse<AlbumOfTheDay, ApiError>(
        url = url,
        httpMethod = HttpMethod.Post,
        contentType = Json,
        deserializer = object : KSerializer<AlbumOfTheDay> {
            override val descriptor: SerialDescriptor =
                buildClassSerialDescriptor("Album") {
                    element<Long>("albumId")
                    element<String>("title")
                    element<String>("blurb")
                    element<Long>("imageId")
                    element<String>("articleUrl")
                    element<String>("genre")
                    element<String>("contributor")
                    element<String>("publishedDate")
                }

            override fun serialize(encoder: Encoder, value: AlbumOfTheDay) {
                throw UnsupportedOperationException("Not needed for deserialization")
            }

            // All this just to flatten two JSON objects?
            override fun deserialize(decoder: Decoder): AlbumOfTheDay {
                val jsonDecoder =
                    decoder as? JsonDecoder ?: error("This class can be loaded only by JSON")

                val jsonObj = jsonDecoder.decodeJsonElement().jsonObject
                val card = jsonObj["card"]!!.jsonObject

                return AlbumOfTheDay(
                    albumId = card["albumId"].toString().toLong(),
                    title = card["title"]!!.toString(),
                    blurb = card["blurb"]!!.toString(),
                    imageId = card["imageId"]!!.toString().toLong(),
                    articleUrl = card["articleUrl"]!!.toString(),
                    genre = card["genre"]!!.toString(),
                    contributor = card["contributor"]!!.toString(),
                    publishedDate = jsonObj["publishedDate"]!!.toString()
                )
            }
        }
    )
}
