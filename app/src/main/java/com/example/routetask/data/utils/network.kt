package com.example.routetask.data.utils

import android.Manifest
import android.content.Context
import android.content.Context.CONNECTIVITY_SERVICE
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.annotation.RequiresPermission
import dagger.hilt.android.qualifiers.ApplicationContext
import jakarta.inject.Inject

class NetworkUtils @Inject constructor(
    @ApplicationContext private val applicationContext: Context
) :NetworkMonitor {

    @RequiresPermission(Manifest.permission.ACCESS_NETWORK_STATE)
    override fun isConnected(): Boolean {
        return isNetworkAvailable()
    }

    @RequiresPermission(Manifest.permission.ACCESS_NETWORK_STATE)
    fun isNetworkAvailable(): Boolean {
        val connectivityManager =
            applicationContext.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager

        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            checkNetworkConnectionModern(connectivityManager)
        } else {
//        checkNetworkConnectionLegacy(connectivityManager)
            false
        }
    }

    @RequiresPermission(Manifest.permission.ACCESS_NETWORK_STATE)
    @RequiresApi(Build.VERSION_CODES.M)
    private fun checkNetworkConnectionModern(connectivityManager: ConnectivityManager): Boolean {
        val network = connectivityManager.activeNetwork
        network ?: return false

        val networkCapabilities = connectivityManager.getNetworkCapabilities(network)
        networkCapabilities ?: return false

        return networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) &&
                networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)
    }
}
