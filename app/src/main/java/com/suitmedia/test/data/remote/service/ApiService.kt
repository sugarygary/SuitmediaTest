package com.suitmedia.test.data.remote.service

import com.suitmedia.test.data.remote.response.GetUserResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/api/users")
    suspend fun getUsers(
        @Query("page") page: Int? = null, @Query("per_page") qty: Int? = null
    ): GetUserResponse
}