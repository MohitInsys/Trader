package com.example.trader.retrofit


import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers



interface ApiServices  {
    @Headers("Content-Type: application/json")
    @GET("/api/v3/ticker/24hr")
    suspend fun getApiServices(): Response<MutableList<ApiData>>


}