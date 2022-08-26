package com.example.trader.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.trader.Fragment.ProfileFragment
import com.example.trader.R
import com.example.trader.database.User
import com.example.trader.databinding.ItemofprofilerecyclerviewBinding


class ProfileRVadapter(val context:ProfileFragment): RecyclerView.Adapter<ProfileRVadapter.MyViewHolder>() {
    var item=ArrayList<User>()
    fun setdata(data:ArrayList<User>)
    {
            this.item=data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
                val binding = DataBindingUtil.inflate<ItemofprofilerecyclerviewBinding>(
            LayoutInflater.from(parent.getContext()), R.layout.itemofprofilerecyclerview, parent, false)
        return MyViewHolder(binding)
     }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(item[position])
    }

    override fun getItemCount(): Int {
       return item.size
    }
    class MyViewHolder(var binding: ItemofprofilerecyclerviewBinding):RecyclerView.ViewHolder(binding.root) {
            fun bind(data:User){
                binding.textviewforname.text=data.name
                binding.textviewforEmail.text=data.email
            }
    }
    fun getDataList():ArrayList<User>{
        return item
    }
}