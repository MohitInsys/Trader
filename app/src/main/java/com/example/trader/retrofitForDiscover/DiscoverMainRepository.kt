package com.example.trader.retrofitForDiscover


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData


class DiscoverMainRepository {
    private val apiServices:DiscoverApiService
    companion object{
        const val TAG="MainRep"
    }
    init {
        apiServices=DiscoverCommon.getApiService
    }
    var getLiveData= MutableLiveData<MutableList<DiscoverApiData>>()
    var newLiveData=getLiveData as LiveData<List<DiscoverApiData>>

    suspend fun getList(name:String): DiscoverApiData? {

        try {
            var result = apiServices.getGender(name)
            return result.body()
        } catch (e: Exception) {
            Log.e("Exception Tag", e.localizedMessage ?: "")
        }
        return  null
    }
}