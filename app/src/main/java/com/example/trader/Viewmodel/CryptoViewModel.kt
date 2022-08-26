package com.example.trader.Viewmodel

import com.example.trader.retrofit.ApiData
import com.example.trader.retrofit.MainRepository
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


    init {
        viewModelScope.launch {


            var cryptoList = mainRepository.getCryptoList()                     //fetching data from api in form of list
            getList.value =cryptoList
        }

    }
}