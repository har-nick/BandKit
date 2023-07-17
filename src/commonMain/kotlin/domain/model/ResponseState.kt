package domain.model

sealed class ResponseState<T> {
    class Success<T>(val data: T? = null) : ResponseState<T>()
    class Saving<T>(val progress: Int? = null) : ResponseState<T>()
    class Loading<T>(val progress: Int? = null) : ResponseState<T>()
    class Fetching<T>(val progress: Int? = null) : ResponseState<T>()
    class Error<T>(val reason: String? = null) : ResponseState<T>()
}
