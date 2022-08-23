package com.example.trader.database/*
package com.example.trader.database

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application):AndroidViewModel(application){
    private val readAll:LiveData<List<User>>
    private val userRepo:UserRepo
    init {
        val userDao=UserDataBase.getDatabase(application)
        userRepo= UserRepo(userDao)
        readAll=userRepo.readALLData
    }
    fun addUser(user: User){
        viewModelScope.launch (Dispatchers.IO){
            userRepo.addUser(user)
        }
    }
}*/
