package com.example.trader.retrofitForDiscover

import com.example.trader.retrofitForDiscover.DiscoverCommon.Companion.baseurl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object DiscoverRetroInstance {
    private var retrofit:Retrofit?=null
    val base_url="https://api.genderize.io/"

    fun getRetroInstance(baseUrl :String):Retrofit{

        if(retrofit==null) {

            retrofit=Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!

    }
}