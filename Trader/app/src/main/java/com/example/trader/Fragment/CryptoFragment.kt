package com.example.trader.Fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.trader.Adapter.ApiAdapter
import com.example.trader.Viewmodel.CryptoViewModel
import com.example.trader.databinding.FragmentCryptoBinding


class CryptoFragment : Fragment() {

    private var binding: FragmentCryptoBinding? = null
    var cryptoViewModel: CryptoViewModel? = null
    lateinit var adapter: ApiAdapter
    var lastItemClickedPosition:Int=-1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = FragmentCryptoBinding.inflate(layoutInflater)
        cryptoViewModel= ViewModelProvider(this)[CryptoViewModel::
        class.java]


        cryptoViewModel!!.LiveData.observe(this)
        {
            Log.e("MainActivity", "DogList" + it.get(0).symbol)
            if (it != null) {
                cryptoViewModel!!.Listview?.addAll(it)
                adapter = ApiAdapter(this@CryptoFragment, it)
                adapter.notifyDataSetChanged()
                binding!!.recyclerview.adapter = adapter
            }
            adapter.setOnItemClickListener(object : ApiAdapter.Onclickinter {
                override fun onClick(position: Int) {
                    //var animation= AnimationUtils.loadAnimation(context, R.anim.fade_in)
                 /*   lastItemClickedPosition = position
                    var intent = Intent(context, MainActivity2::class.java)
                    var dog = cryptoViewModel!!.dogListview[position]
                    intent.putExtra("model", dog)
                    //binding.vertRV.setAnimation(animation)
                    startActivity(intent)*/

                    //(context as Activity).overridePendingTransition(R.anim.from_left,R.anim.to_right)
                }


                override fun onLongclick(position: Int) {
                    TODO("Not yet implemented")
                }

            })
        }}
    }


