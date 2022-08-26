package com.example.trader.Viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.trader.retrofitForDiscover.DiscoverApiData
import com.example.trader.retrofitForDiscover.DiscoverMainRepository
import kotlinx.coroutines.launch
import retrofit2.Response


class DiscoverViewModel() : ViewModel() {
   val mainRepository by lazy{
        DiscoverMainRepository()
    }
    val getList by lazy {
        MutableLiveData<DiscoverApiData>()
    }
    var name:MutableLiveData<String>?=null
    val newLiveData=getList as LiveData<DiscoverApiData>                                //updating newdata to our view

    fun searchDeatils(query:String){

        viewModelScope.launch {


            var details=mainRepository.getList(query)                                   //fetching response from API
            getList.value=details

        }

    }



}
