package com.example.trader.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.trader.R
import com.example.trader.databinding.ActivityUpdateBinding

class UpdateActivity : AppCompatActivity() {
    lateinit var binding:ActivityUpdateBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)
        binding=ActivityUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val email=  intent.getStringExtra("LoggedEmail")
        binding.textviewofEmailInUpdate.setText(email)



        binding.imageviewofCross.setOnClickListener{
            finish()
        }
        binding.updatedetails.setOnClickListener{
            val newName:String=binding.edittextfornewname.text.toString()
            var _name=intent.putExtra("new_name",newName)
            setResult(RESULT_OK,_name)
            finish()
        }
    }



}