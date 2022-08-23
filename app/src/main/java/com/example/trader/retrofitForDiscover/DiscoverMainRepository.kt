package com.example.trader.retrofitForDiscover


import retrofit2.Response


class DiscoverMainRepository {
    suspend fun getPost():Response<DiscoverApiData>{
       return   DiscoverRetroInstance.api.getPost()
    }
}

