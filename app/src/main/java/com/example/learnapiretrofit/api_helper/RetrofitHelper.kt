package com.example.learnapiretrofit.api_helper

import com.example.learnapiretrofit.service.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    const val baseUrl = "https://675d9dbf63b05ed079785aaa.mockapi.io/" // base url of api

    private fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    fun getApiService() : ApiService{
        return getInstance().create(ApiService::class.java)
    }
}