package Retrofit

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface ApiServices {
    @Headers("Content-Type: application/json")
    @GET("/v1/breeds/")
    suspend fun getApiServices(@Query("page") page: Int, @Query("limit") limit:Int): Response<List<ApiData>>


}