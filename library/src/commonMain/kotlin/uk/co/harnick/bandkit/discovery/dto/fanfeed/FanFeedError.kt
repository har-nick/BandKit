package uk.co.harnick.bandkit.discovery.dto.fanfeed

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind.STRING
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import uk.co.harnick.bandkit.core.dto.ApiError

internal object FanFeedErrorSerializer : KSerializer<FanFeedErrorDto> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("FanFeedErrorDto", STRING)

    override fun deserialize(decoder: Decoder): FanFeedErrorDto =
        FanFeedErrorDto(decoder.decodeString())

    override fun serialize(encoder: Encoder, value: FanFeedErrorDto) =
        encoder.encodeString(value.value)
}

@Serializable(with = FanFeedErrorSerializer::class)
internal data class FanFeedErrorDto internal constructor(val value: String) : ApiError {
    override val message: String = "An unidentified error occurred when fetching fan feed."
}
