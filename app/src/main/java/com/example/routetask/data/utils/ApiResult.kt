package com.example.routetask.data.utils

sealed class ApiResult<out T> {
    object Loading:ApiResult<Nothing>()
    data class Success<out T>(val response:T):ApiResult<T>()
    data class Error(val error:Exception):ApiResult<Nothing>()
}