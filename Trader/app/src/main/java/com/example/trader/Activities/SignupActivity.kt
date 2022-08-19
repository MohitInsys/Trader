package com.example.trader.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.trader.R
import com.example.trader.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.textviewOfLogin.setOnClickListener{
            var intent= Intent(this,LoginActivity::class.java)
            startActivity(intent)
            overridePendingTransition(com.google.android.material.R.anim.abc_slide_in_top,
                com.google.android.material.R.anim.abc_slide_out_bottom)
        }
        binding.ButtonForSignupButton.setOnClickListener{
            val intent=Intent(this,StartPageActivity::class.java)
            startActivity(intent)
        }
    }
}