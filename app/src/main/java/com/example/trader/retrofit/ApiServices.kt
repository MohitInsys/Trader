package com.example.trader.retrofit

import com.example.trader.retrofit.ApiData
import com.example.trader.retrofitForDiscover.DiscoverApiService
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface ApiServices  {
    @Headers("Content-Type: application/json")
    @GET("/api/v3/ticker/24hr")
    suspend fun getApiServices(): Response<List<ApiData>>


}