package com.example.trader.Fragment


import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.trader.BR
import com.example.trader.Viewmodel.DiscoverViewModel
import com.example.trader.databinding.FragmentDiscoverBinding


class DiscoverFragment : Fragment() {

    lateinit var binding: FragmentDiscoverBinding
    var discoverViewModel: DiscoverViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = FragmentDiscoverBinding.inflate(layoutInflater)
        discoverViewModel= ViewModelProvider(this)[DiscoverViewModel::class.java]                                   //initialising our viewmodel
        discoverViewModel?.newLiveData?.observe(this@DiscoverFragment, Observer {
            binding.setVariable(BR.details,it)
        })


        binding.editviewforsearch.addTextChangedListener(object : TextWatcher {                                             //textwatcher to take out take after every data

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }
            override fun afterTextChanged(s: Editable) {


                if (binding.editviewforsearch.hasFocus()) {
                    if(binding.editviewforsearch.text.length>2){
                   val searched_name= binding.editviewforsearch.text.toString()
                    discoverViewModel?.searchDeatils(searched_name)

                }}
            }
        })

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return binding.root
    }
}





