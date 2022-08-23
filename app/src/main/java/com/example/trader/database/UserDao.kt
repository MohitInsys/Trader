package com.example.trader.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.trader.Activities.SignupActivity

interface UserDao{

    @Query("SELECT * FROM USER_DETAILS ORDER BY id DESC ")
    fun insertDetails():List<User>?

    @Insert
    fun inserUser(user: User?)
    @Delete
    fun deleteUser(user: User?)
    @Update
    fun updateUser(user: User?)
}
