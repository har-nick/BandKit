package uk.co.harnick.bandkit.domain.model

sealed class BandKitException(override val message: String?) : Exception() {
    data object TokenException : BandKitException("Token was incorrect, or missing from request.")
    data object UnknownException : BandKitException("An unknown exception occurred.")
}
