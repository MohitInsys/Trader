package com.example.trader.Fragment
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.*
import android.widget.ListView
import androidx.appcompat.widget.SearchView

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.trader.Activities.CrytpoDetails

import com.example.trader.Adapter.CryptoAdapter
import com.example.trader.R


import com.example.trader.Viewmodel.CryptoViewModel
import com.example.trader.databinding.FragmentCryptoBinding
class CryptoFragment : Fragment() {

    lateinit var binding: FragmentCryptoBinding
    var cryptoViewModel: CryptoViewModel? = null
    lateinit var adapter1: CryptoAdapter
    var lastItemClickedPosition:Int=-1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentCryptoBinding.inflate(layoutInflater)
        cryptoViewModel = ViewModelProvider(this)[CryptoViewModel::class.java]
        // val searchView=binding.editviewofsearch.text

        cryptoViewModel!!.LiveData.observe(this)
        {
            Log.e("MainActivity", "CryptoList" + it.get(0).symbol)
            if (it != null) {
                cryptoViewModel!!.Listview.addAll(it)
                adapter1 = CryptoAdapter(this@CryptoFragment, it)
                adapter1.notifyDataSetChanged()
                binding.recyclerview.adapter = adapter1
                adapter1.setOnItemClickListener(object : CryptoAdapter.Onclickinter {
                    override fun onClick(position: Int) {
                        lastItemClickedPosition = position
                        var intent = Intent(context, CrytpoDetails::class.java)
                        var crypto = cryptoViewModel!!.Listview[position]
                        intent.putExtra("model", crypto)
                        startActivity(intent)
                    }

                    override fun onLongclick(position: Int) {
                        TODO("Not yet implemented")
                    }
                })
            }
        }


    }
override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return (binding.root)
    }
}



