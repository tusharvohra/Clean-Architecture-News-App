package com.carousell.common_utils

sealed class Resource<T> {
    class Loading<T> : Resource<T>()
    class Success<T>(val data: T?) : Resource<T>()
    class Error<T>(val msg: String, val data: T? = null) : Resource<T>()
}
