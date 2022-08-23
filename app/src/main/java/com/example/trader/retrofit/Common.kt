package com.example.trader.retrofit

object Common {

    private const val baseurl="https://api2.binance.com/"
    val getApiService: ApiServices
        get() = RetroInstance.getRetroInstance(baseurl).create(ApiServices::class.java)
}