package com.example.trader.retrofitForDiscover
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface DiscoverApiService{
    @GET( )
    suspend fun getGender(@Query("name") name : String) :Call<DiscoverApiData>

}