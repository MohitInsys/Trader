package com.example.trader.Activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.trader.database.User
import com.example.trader.database.UserDataBase
import com.example.trader.databinding.ActivityLoginBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    lateinit var userDataBase: UserDataBase
    lateinit var user: User
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userDataBase = UserDataBase.getappdatabase(this)!!
        val sharedPreferences:SharedPreferences=getSharedPreferences("Data", Context.MODE_PRIVATE)


       binding.textviewOfSignUP.setOnClickListener {

            var intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
            overridePendingTransition(com.google.android.material.R.anim.abc_slide_in_bottom,
                com.google.android.material.R.anim.abc_slide_out_top)

        }

        binding.ButtonForloginButton.setOnClickListener(View.OnClickListener {

            var email = binding.editviewofEmail.text.toString()
            if (email != null) {

                GlobalScope.launch(Dispatchers.Main) {

                    val password = UserDataBase.getappdatabase(this@LoginActivity)?.userdao()?.findByPassword(email.toString())
                    val editor:SharedPreferences.Editor=sharedPreferences.edit()
                    editor.putString("Email",binding.editviewofEmail.text.toString())
                    editor.putString("Password",binding.editviewofpass.text.toString())
                     editor.commit()
                    if (binding.editviewofpass.text.toString().equals(password)) {
                        val intent = Intent(this@LoginActivity, StartPageActivity::class.java)
                        startActivity(intent)
                        finish()
                        }
                    else{
                        Toast.makeText(this@LoginActivity,"Incorrect Details",Toast.LENGTH_SHORT).show()
                    }



                    }

                }
        })
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        val _email= intent?.getStringExtra("Email")
        binding.editviewofEmail.setText(_email)
    }
}




