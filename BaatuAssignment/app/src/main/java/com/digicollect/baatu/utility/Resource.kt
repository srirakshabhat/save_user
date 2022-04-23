package com.digicollect.baatu.utility

/*this resource class is suggested by google to handle the response, error
* and loading state*/
sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null,
    val statusId : String? = null
) {
    class Success<T>(data: T) : Resource<T>(data)
    class Loading<T>(data: T? = null) : Resource<T>(data)
    class Error<T>(message: String?, data: T? = null) : Resource<T>(data, message)
}