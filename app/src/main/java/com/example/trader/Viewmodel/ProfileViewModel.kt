package com.example.trader.Viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.trader.database.User
import com.example.trader.database.UserDataBase

class ProfileViewModel(app :Application) : AndroidViewModel(app) {
    lateinit var allUser:MutableLiveData<List<User>>
    init {
            allUser= MutableLiveData( )
    }
    fun getAllUserObserver():MutableLiveData<List<User>>
    {
        return allUser
    }
    fun getAllUser(){
       val userDao =UserDataBase.getappdatabase((getApplication())).userdao()
        val list=userDao.getallUserInfo()
        allUser.postValue(list)
    }
    fun inserUserInfo(user: User){
        UserDataBase.getappdatabase(getApplication())?.userdao()
    }
}