package com.example.trader.Activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.trader.database.User
import com.example.trader.database.UserDataBase
import com.example.trader.databinding.ActivitySignupBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class   SignupActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignupBinding
    lateinit var dataBase: UserDataBase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dataBase= UserDataBase.getappdatabase(this)!!
        val sharedPreferences:SharedPreferences=getSharedPreferences("Data", Context.MODE_PRIVATE)
        binding.textviewOfLogin.setOnClickListener{
            val intent= Intent(this,LoginActivity::class.java)
            startActivity(intent)
            overridePendingTransition(com.google.android.material.R.anim.abc_slide_in_top,
                com.google.android.material.R.anim.abc_slide_out_bottom)
        }

        binding.ButtonForSignupButton.setOnClickListener {
                if(writeData()==true) {
                    val intent = Intent(this, StartPageActivity::class.java)

                    val editor: SharedPreferences.Editor=sharedPreferences.edit()
                    editor.putString("Email",binding.editviewofemailinsignup.text.toString())
                    editor.putString("Password",binding.editviewofpassinsignup.text.toString())
                    editor.commit()

                        val intent1 = Intent(this, StartPageActivity::class.java)
                        startActivity(intent1)
                        finish()


                }
        }
    }
    fun writeData():Boolean{
            val email= binding.editviewofemailinsignup.text.toString()
            val pass=binding.editviewofpassinsignup.text.toString()
            val name=binding.EditviewofNameinsignup.text.toString()
        if (email.isNotEmpty() && pass.isNotEmpty() && name.isNotEmpty()){
            val user = User(0,email,pass,name)
            GlobalScope.launch(Dispatchers.IO) {
                dataBase.userdao().insertUser(user)
            }
           return true
        }
        else
            Toast.makeText(this,"Please Enter Details",Toast.LENGTH_SHORT).show()

            return false
            }
    }



