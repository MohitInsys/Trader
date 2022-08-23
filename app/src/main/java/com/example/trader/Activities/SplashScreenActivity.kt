package com.example.trader.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
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
        UserDataBase.get(application)
        var i= Intent(this,LoginActivity::class.java)
        Handler().postDelayed({
            startActivity(i)
            finish()
        }, 3000)
    }
}