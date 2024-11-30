package uk.co.harnick.bandkit.util

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind.STRING
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal typealias UnknownType = @Serializable(UnknownTypeSerializer::class) String

internal object UnknownTypeSerializer : KSerializer<String> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("Unknown", STRING)
    override fun deserialize(decoder: Decoder): String = decoder.decodeString()
    override fun serialize(encoder: Encoder, value: String) = encoder.encodeString(value)
}
