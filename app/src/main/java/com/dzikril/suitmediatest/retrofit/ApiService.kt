package com.dzikril.suitmediatest.retrofit

import com.dzikril.suitmediatest.response.UserResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("users")
    suspend fun getUsers(
        @Query("page") page: Int? = null,
        @Query("per_page") per_page: Int? = null,
    ): UserResponse
}