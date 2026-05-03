package uk.co.harnick.bandkit.discovery.dto

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.element
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.jsonObject

@Serializable(with = AlbumOfTheDaySerializer::class)
public class AlbumOfTheDay internal constructor(
    public val albumId: Long,

    public val title: String,

    public val blurb: String,

    public val imageId: Long,

    public val articleUrl: String,

    public val genre: String,

    public val contributor: String,

    public val publishedDate: String
)

// TODO: All this just to flatten two JSON objects?
internal object AlbumOfTheDaySerializer : KSerializer<AlbumOfTheDay> {
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
