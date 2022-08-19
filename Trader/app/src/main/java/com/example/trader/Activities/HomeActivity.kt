package com.example.trader.Activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.trader.R
import com.example.trader.databinding.ActivityHomeBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
     lateinit var navController:NavController
     lateinit var binding2: ActivityHomeBinding
    lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding2=ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding2.root)




        /*val appBarConfiguration = AppBarConfiguration(setOf(
        R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)*/

      /* val navHostFrag:NavHostFragment=supportFragmentManager.findFragmentById(R.id.cryptoFragment) as NavHostFragment
        navController=navHostFrag.navController
        val bottomNavigationView=findViewById<BottomNavigationView>(R.id.navBar)
        bottomNavigationView.setupWithNavController(navController)*/

    }
}