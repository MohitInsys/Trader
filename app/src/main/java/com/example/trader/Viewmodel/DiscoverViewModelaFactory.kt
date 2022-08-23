package com.example.trader.Viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.trader.retrofitForDiscover.DiscoverMainRepository

class DiscoverViewModelaFactory(private val repository: DiscoverMainRepository):ViewModelProvider.Factory  {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DiscoverViewModel(repository)as T
    }
}