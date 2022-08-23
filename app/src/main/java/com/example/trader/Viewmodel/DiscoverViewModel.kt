package com.example.trader.Viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.trader.retrofitForDiscover.DiscoverApiData
import com.example.trader.retrofitForDiscover.DiscoverMainRepository
import kotlinx.coroutines.launch
import retrofit2.Response


class DiscoverViewModel(private val repository: DiscoverMainRepository) : ViewModel() {
    val myResponse:MutableLiveData<Response<DiscoverApiData>> = MutableLiveData()
         fun getPost(){
             viewModelScope.launch {
                 val response=repository.getPost()
                 myResponse.value=response
             }
         }

}