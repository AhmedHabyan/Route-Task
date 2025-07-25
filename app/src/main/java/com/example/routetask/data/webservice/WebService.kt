package com.example.routetask.data.webservice

import com.example.routetask.data.Entity.PhotoResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface WebService {

   @Headers("Authorization: aHVo34F6LZN3NfC0qCNxPpIgIeGLYYHOMfeKq4OPal6ZmmpgXGDChEjW")
    @GET("curated")
    suspend fun getPhotos():PhotoResponse
}