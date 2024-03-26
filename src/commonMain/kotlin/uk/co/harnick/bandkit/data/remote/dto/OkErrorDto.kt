package uk.co.harnick.bandkit.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class OkErrorDto(
    @SerialName("error")
    val isError: Boolean,
    @SerialName("error_message")
    val errorMessage: String
)
