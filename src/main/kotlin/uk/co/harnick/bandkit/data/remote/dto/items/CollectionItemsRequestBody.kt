package uk.co.harnick.bandkit.data.remote.dto.items

import kotlinx.datetime.Clock
import kotlinx.serialization.EncodeDefault
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@OptIn(ExperimentalSerializationApi::class)
@Serializable
internal data class CollectionItemsRequestBody(
    @SerialName("fan_id")
    val userId: Long,
    @SerialName("count")
    val itemCount: Int
) {
    @EncodeDefault
    @SerialName("older_than_token")
    val olderThanToken: String = "${Clock.System.now().epochSeconds}::a::"
}
