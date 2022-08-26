package com.example.trader.Adapter

import android.graphics.Color
import com.example.trader.retrofit.ApiData
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.trader.BR
import com.example.trader.Fragment.CryptoFragment
import com.example.trader.R
import com.example.trader.databinding.ItemofcryptorecyclerviewBinding
import java.util.*


import kotlin.collections.ArrayList



class CryptoAdapter(val context: CryptoFragment, var crypto_list:List<ApiData>):RecyclerView.Adapter<CryptoAdapter.MyViewHolder>() {
    private var crypto: List<ApiData>? = null


    override fun getItemCount(): Int {
        return crypto_list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = DataBindingUtil.inflate<ItemofcryptorecyclerviewBinding>(
            LayoutInflater.from(parent.getContext()),
            R.layout.itemofcryptorecyclerview,
            parent,
            false)

        return MyViewHolder(binding, minter)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {                                                 //to bind our data to layout
      /*if(holder.binding.textviewforchangepercentageofcrypto.text.toString().toInt()>0){
            holder.binding.textviewforchangepercentageofcrypto.setTextColor(Color.parseColor("#FFFFFFFF"))}*/
        holder.binding.setVariable(BR.crypto_details, crypto_list[position])
      }



    class MyViewHolder(var binding: ItemofcryptorecyclerviewBinding, l: Onclickinter) :                                     //to hold view for recyclerview
        RecyclerView.ViewHolder(binding.root) {
        init {
            itemView.setOnClickListener {
                l.onClick(adapterPosition)
            }
        }
    }

    interface Onclickinter {

        fun onClick(position: Int)
        fun onLongclick(position: Int)
    }


    lateinit var minter: Onclickinter
    fun setOnItemClickListener(listen: Onclickinter) {
        minter = listen
    }



}





