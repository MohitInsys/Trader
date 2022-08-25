
package com.example.trader.database

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class UserViewModel(app :Application) : AndroidViewModel(app) {
    lateinit var allUser: MutableLiveData<List<User>?>
    init {
            allUser= MutableLiveData( )
    }
    fun getAllUserObserver(): MutableLiveData<List<User>?>
    {
        return allUser
    }
   suspend fun getAllUser(){
       val userDao = UserDataBase.getappdatabase((getApplication()))?.userdao()
        val list=userDao?.getAll()
        allUser.postValue(list)
    }
    suspend fun insertUserInfo(user: User){
       val userdao= UserDataBase.getappdatabase(getApplication())?.userdao()
        userdao?.insertUser(user)
        getAllUser()
    }
   suspend fun deleteUserInfo(user: User){
        val userdao= UserDataBase.getappdatabase(getApplication())?.userdao()
        userdao?.deleteUser(user)
        getAllUser()
    }
   suspend fun updateUserInfo(user: User){
        val userdao= UserDataBase.getappdatabase(getApplication())?.userdao()
        userdao?.updateUser(String.toString(), String.toString())
        getAllUser()
    }




}
