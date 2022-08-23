package com.example.trader.Adapter

import com.example.trader.retrofit.ApiData
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.trader.BR
import com.example.trader.Fragment.CryptoFragment
import com.example.trader.R
import com.example.trader.databinding.ItemofcryptorecyclerviewBinding

class CryptoAdapter(val context: CryptoFragment, var crypto_list:List<ApiData>):RecyclerView.Adapter<CryptoAdapter.MyViewHolder>(){
    private var crypto: List<ApiData>? = null

    fun setDogList(dog_list: List<ApiData>?) {
        crypto_list = crypto!!

    }
    override fun getItemCount(): Int {
        return crypto_list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = DataBindingUtil.inflate<ItemofcryptorecyclerviewBinding>(
            LayoutInflater.from(parent.getContext()), R.layout.itemofcryptorecyclerview, parent, false)

        return MyViewHolder(binding, minter)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.setVariable(BR.crypto_details,crypto_list[position])
    }


    class MyViewHolder (var binding:ItemofcryptorecyclerviewBinding, l: Onclickinter) :
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