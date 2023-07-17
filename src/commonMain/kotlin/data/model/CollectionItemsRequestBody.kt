package data.model

import kotlinx.datetime.Clock
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CollectionItemsRequestBody(
    @SerialName("fan_id")
    val userId: Long,
    @SerialName("count")
    val itemCount: Int
) {
    @SerialName("older_than_token")
    var olderThanToken: String = "${Clock.System.now().epochSeconds}::a::"
        set(value) {
            field = this.olderThanToken
        }
}
