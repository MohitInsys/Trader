package com.example.trader.Activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.trader.R
import com.example.trader.databinding.ActivityHomeBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
     lateinit var navController:NavController
     lateinit var binding2: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding2=ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding2.root)

        val navHostFrag:NavHostFragment=supportFragmentManager.findFragmentById(R.id.homefrag) as NavHostFragment
        navController=navHostFrag.navController
        val bottomNavigationView=findViewById<BottomNavigationView>(R.id.navBar)
        bottomNavigationView.setupWithNavController(navController)

    }
}