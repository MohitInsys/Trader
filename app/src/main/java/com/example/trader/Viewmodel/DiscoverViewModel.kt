package com.example.trader.Viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.trader.retrofitForDiscover.DiscoverApiData
import com.example.trader.retrofitForDiscover.DiscoverMainRepository
import kotlinx.coroutines.launch
import retrofit2.Response


class DiscoverViewModel(private val repository: DiscoverMainRepository,name:String) : ViewModel() {
   val mainRepository by lazy{
        DiscoverMainRepository()
    }
    val getList by lazy {
        MutableLiveData<List<DiscoverApiData>>()
    }
    var name:MutableLiveData<String>?=null

    init {
        viewModelScope.launch {


            val details=mainRepository.getList()
            getList.value=details
        }

    }



}
