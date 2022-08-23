package com.example.trader.retrofitForDiscover
import retrofit2.Response
import retrofit2.http.GET

interface DiscoverApiService{
    @GET("?name=Mohit")
    suspend fun getPost():Response<DiscoverApiData>
}