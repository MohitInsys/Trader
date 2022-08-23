package com.example.trader.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.trader.R
import com.example.trader.database.User
import com.example.trader.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignupBinding
    lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        user=User("","","")
        user.email=binding.editviewofemailinsignup.toString()
        user.password=binding.editviewofpassinsignup.toString()
        user.password=binding.EditviewofNameinsignup.toString()

        binding.textviewOfLogin.setOnClickListener{
            var intent= Intent(this,LoginActivity::class.java)
            startActivity(intent)
            overridePendingTransition(com.google.android.material.R.anim.abc_slide_in_top,
                com.google.android.material.R.anim.abc_slide_out_bottom)
        }
        binding.ButtonForSignupButton.setOnClickListener{
            val intent=Intent(this,StartPageActivity::class.java)
            if(input(user)==true){
            startActivity(intent)
            }
            else
                Toast.makeText(this,"wrong input",Toast.LENGTH_SHORT).show()
        }
    }
    fun input(user:User):Boolean
    {
        if (user.email==null&&user.password==null&&user.name==null)
        { return false
    }
        return true
    }

}