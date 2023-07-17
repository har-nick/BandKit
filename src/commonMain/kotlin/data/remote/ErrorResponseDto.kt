package data.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ErrorResponseDto(
    @SerialName("error")
    val isError: Boolean,
    @SerialName("error_message")
    val errorMessage: String
)
