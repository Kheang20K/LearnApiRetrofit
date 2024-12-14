package com.example.learnapiretrofit.service

import com.example.learnapiretrofit.model.Info
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("testing/user")
    suspend fun getUser() : Response<List<Info>>
}