package uk.co.harnick.bandkit.discovery.dto.editorpicks

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import uk.co.harnick.bandkit.core.dto.ApiError

@Serializable
internal class EditorPicksError internal constructor(
    @SerialName("__api_special__")
    val apiSpecial: String,
    @SerialName("error_type")
    val errorMessage: String
) : ApiError {
    override val message: String = when (errorMessage) {
        "Endpoints::MissingParamError" -> "The request is missing ID parameters."
        "Endpoints::ParamParseError" -> "The passed IDs were invalid."
        else -> "An unhandled error has occurred fetching Editor's picks: $errorMessage"
    }
}
