package uk.co.harnick.bandkit.data.remote.dto.items

import kotlinx.datetime.Clock
import kotlinx.serialization.EncodeDefault
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@OptIn(ExperimentalSerializationApi::class)
@Serializable
internal class CollectionItemsRequestBody(
    @SerialName("fan_id")
    val userId: Long
) {
    @EncodeDefault
    @SerialName("count")
    val itemCount: Int = Int.MAX_VALUE

    @EncodeDefault
    @SerialName("older_than_token")
    val olderThanToken: String = "${Clock.System.now().epochSeconds}::a::"
}
