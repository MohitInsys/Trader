package com.example.trader.retrofitForDiscover




class DiscoverCommon {
    companion object{
        const val baseurl="https://api.genderize.io/"
        val getApiService:DiscoverApiService
            get() = DiscoverRetroInstance.getRetroInstance(baseurl).create(DiscoverApiService::class.java)
    }


}