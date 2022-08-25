package com.example.trader.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.example.trader.R
import com.example.trader.databinding.ActivityStartPageBinding

class StartPageActivity : AppCompatActivity() {

    lateinit var binding:ActivityStartPageBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityStartPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonforgetstarted.setOnClickListener(){
            val intent= Intent(this,HomeActivity::class.java)
            startActivity(intent)
            finish()

        }
    }
}