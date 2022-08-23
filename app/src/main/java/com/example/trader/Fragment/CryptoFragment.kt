package com.example.trader.Fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.method.TextKeyListener.clear
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.SearchView
import androidx.core.view.contains
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.trader.Activities.CrytpoDetails

import com.example.trader.Adapter.CryptoAdapter


import com.example.trader.Viewmodel.CryptoViewModel

import com.example.trader.databinding.FragmentCryptoBinding
import com.example.trader.retrofit.ApiData
import java.util.*


class CryptoFragment : Fragment() {

    lateinit var binding: FragmentCryptoBinding
    var cryptoViewModel: CryptoViewModel? = null
    lateinit var adapter1: CryptoAdapter
    var lastItemClickedPosition:Int=-1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = FragmentCryptoBinding.inflate(layoutInflater)
        cryptoViewModel= ViewModelProvider(this)[CryptoViewModel::class.java]



        cryptoViewModel!!.LiveData.observe(this)
        {
            Log.e("MainActivity", "CryptoList" + it.get(0).symbol)
            if (it != null) {
                cryptoViewModel!!.Listview.addAll(it)
                adapter1 = CryptoAdapter(this@CryptoFragment, it)
                adapter1.notifyDataSetChanged()
                binding.recyclerview.adapter = adapter1

             /*   searchView.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
                    override fun onQueryTextSubmit(newString: String?): Boolean {
                        binding.cardviewofsearch.clearFocus()
                        if(binding.recyclerview.contains(newString))
                            adapter1..filter(newString)
                    }

                    override fun onQueryTextChange(newText: String?): Boolean {
                        ListView()
                        val searchText=newText!!.toLowerCase(Locale.getDefault())
                        if(searchText.isNotEmpty()){

                        }
                        return false
                    }

                })

            }*/
            adapter1.setOnItemClickListener(object : CryptoAdapter.Onclickinter {
                override fun onClick(position: Int) {
                    lastItemClickedPosition = position
                    var intent = Intent(context, CrytpoDetails::class.java)
                    var crypto=cryptoViewModel!!.Listview[position]
                    intent.putExtra("model",crypto)
                    startActivity(intent)

                }

                override fun onLongclick(position: Int) {
                    TODO("Not yet implemented")
                }
            })}}}
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }
    }


