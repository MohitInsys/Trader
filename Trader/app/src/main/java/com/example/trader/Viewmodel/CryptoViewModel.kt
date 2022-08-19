package com.example.trader.Viewmodel

import Retrofit.ApiData
import Retrofit.MainRepository
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class CryptoViewModel :ViewModel() {

    val mainRepository by lazy {
        MainRepository()
    }
    val getList by lazy {
        MutableLiveData<List<ApiData>>()
    }
    var Listview = mutableListOf<ApiData>()
    val LiveData = getList as LiveData<List<ApiData>>

    /*val data=mainRepository.getpost()*/
    init {
        viewModelScope.launch {


            var cryptoList = mainRepository.getCryptoList()
            getList.value =cryptoList
        }

    }
}