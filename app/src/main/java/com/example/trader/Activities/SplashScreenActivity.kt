package com.example.trader.Activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import com.example.trader.database.UserDataBase
import com.example.trader.databinding.ActivitySplashScreenBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenActivity : AppCompatActivity() {
    lateinit var binding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
       /* UserDataBase.get(application)*/
        val sharedPreferences:SharedPreferences=getSharedPreferences("Data", Context.MODE_PRIVATE)
        val type:String= sharedPreferences.getString("Email","").toString()


        var i= Intent(this,LoginActivity::class.java)
        Handler().postDelayed({

            if(type.isEmpty())
            {
                startActivity(Intent(this,LoginActivity::class.java))
            }
            else{
                startActivity(Intent(this,HomeActivity::class.java))
            }

            finish()
        }, 3000)
    }
}