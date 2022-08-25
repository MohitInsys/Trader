package com.example.trader.Fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.trader.Viewmodel.DiscoverViewModel
import com.example.trader.Viewmodel.DiscoverViewModelaFactory

import com.example.trader.databinding.FragmentDiscoverBinding
import com.example.trader.retrofitForDiscover.DiscoverApiService


import com.example.trader.retrofitForDiscover.DiscoverMainRepository

class DiscoverFragment : Fragment() {

    lateinit var binding: FragmentDiscoverBinding
   lateinit var discoverViewModel:DiscoverViewModel
    var viewModelaFactory:DiscoverViewModelaFactory?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = FragmentDiscoverBinding.inflate(layoutInflater)

        val repo = DiscoverMainRepository()

        val findText = binding.editviewforsearch.text.toString()
        val name=binding.editviewforsearch.text
        DiscoverApiService.geti


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }
}






