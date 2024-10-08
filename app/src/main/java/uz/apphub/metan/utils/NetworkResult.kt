package uz.apphub.metan.utils

/**
 * Created By Shokirov Begzod on 6/26/2024
 **/
data class NetworkResult<out T>(
 val status: Status,
 val data: T?,
 val message: String?
) {
 companion object {
  fun <T> success(data: T?): NetworkResult<T> =
   NetworkResult(Status.SUCCESS, data, null)

  fun <T> loading(): NetworkResult<T> {
   return NetworkResult(Status.LOADING, null, null)
  }

  fun <T> empty(): NetworkResult<T> {
   return NetworkResult(Status.EMPTY, null, null)
  }

  fun <T> error(message: String?): NetworkResult<T> =
   NetworkResult(Status.ERROR, null, message)
 }
}
