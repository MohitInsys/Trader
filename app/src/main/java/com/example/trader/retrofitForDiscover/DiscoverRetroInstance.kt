package com.example.trader.retrofitForDiscover

import com.example.trader.retrofitForDiscover.DiscoverCommon.Companion.baseurl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object DiscoverRetroInstance {
    private val retrofit by lazy{
        Retrofit.Builder()
            .baseUrl(baseurl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val api:DiscoverApiService by lazy {
        retrofit.create(DiscoverApiService::class.java)
    }
    }
