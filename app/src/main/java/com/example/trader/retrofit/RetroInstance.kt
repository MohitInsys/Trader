package com.example.trader.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroInstance {
    private var retrofit:Retrofit?=null
    val base_url="https://api2.binance.com/api/v3/ticker/24hr/"

    fun getRetroInstance(baseUrl :String): Retrofit {

        if(retrofit ==null) {

            retrofit =Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!

    }
}