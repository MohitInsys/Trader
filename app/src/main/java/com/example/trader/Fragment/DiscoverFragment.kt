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


import com.example.trader.retrofitForDiscover.DiscoverMainRepository

class DiscoverFragment : Fragment() {

    lateinit var binding: FragmentDiscoverBinding
   lateinit var discoverViewModel:DiscoverViewModel
    var viewModelaFactory:DiscoverViewModelaFactory?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=FragmentDiscoverBinding.inflate(layoutInflater)

        val repo=DiscoverMainRepository()



        discoverViewModel=ViewModelProvider(this)[DiscoverViewModel::class.java]
        viewModelaFactory=DiscoverViewModelaFactory(repo)
        discoverViewModel?.myResponse?.value
        discoverViewModel?.myResponse?.observe(this, Observer {response->
            if(response.isSuccessful){
            Log.d("Response",response.body()?.name.toString())
            Log.d("Response",response.body()?.gender.toString())
            Log.d("Response",response.body()?.count.toString())
            Log.d("Response",response.body()?.probability.toString())
                binding.textviewforname.text=response.body()?.name.toString()
                binding.textviewforgender.text=response.body()?.gender.toString()
                binding.textviewforcount.text=response.body()?.count.toString()
                binding.textviewforprobability.text=response.body()?.probability.toString()
            }
            else
                Log.d("Response",response.errorBody().toString())
        })
            }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }
}






