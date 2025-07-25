package com.example.routetask.data.utils

import com.example.routetask.data.Entity.PhotosItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


suspend fun <T> safeCallApi(call: suspend ()->T): Flow<ApiResult<T>> {
    return flow {
        emit(ApiResult.Loading)
        try {

            val response = call.invoke()
            emit(ApiResult.Success(response))
        } catch (exception: Exception) {
            emit(ApiResult.Error(exception))
        }
    }

}


