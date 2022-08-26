package com.example.trader.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.trader.BR
import com.example.trader.R
import com.example.trader.databinding.ActivityCrytpoDetailsBinding
import com.example.trader.retrofit.ApiData

class CrytpoDetails : AppCompatActivity() {
    lateinit var binding:ActivityCrytpoDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityCrytpoDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var i=intent.getSerializableExtra("model") as ApiData
        binding.setVariable(BR.crypto_details2,i)                                                   //sending data to our xml
    }
}