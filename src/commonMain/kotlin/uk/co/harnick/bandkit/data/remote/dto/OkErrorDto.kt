package uk.co.harnick.bandkit.data.remote.dto

import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.statement.HttpResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class OkErrorDto(
    @SerialName("error")
    val isError: Boolean,
    @SerialName("error_message")
    val errorMessage: String
) {
    internal fun mapToClientRequestException(response: HttpResponse): Exception = when (errorMessage) {
        "must be logged in" -> ClientRequestException(response, "No token provided.")
        "missing key fan_id" -> ClientRequestException(response, "fanId was invalid.")
        "missing key older_than_token" -> ClientRequestException(
            response,
            "olderThanToken is invalid."
        )

        else -> ClientRequestException(response, "An unknown exception occurred.")
    }
}
