package com.example.routetask.data.utils

import android.Manifest
import android.content.Context
import android.content.Context.CONNECTIVITY_SERVICE
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.annotation.RequiresPermission
import androidx.core.content.ContextCompat.getSystemService
import dagger.hilt.android.qualifiers.ApplicationContext
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




