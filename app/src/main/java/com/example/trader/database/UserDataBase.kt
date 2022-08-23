package com.example.trader.database


import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities=[User::class],version=1, exportSchema=false)
abstract class UserDataBase: RoomDatabase() {
    abstract fun userdao():UserDao?
   companion object{
        private var INSTANCE:UserDataBase?=null

       fun getappdatabase(context: Context):RoomDatabase{

        if(INSTANCE==null){
            INSTANCE=Room.databaseBuilder<UserDataBase>(
                context.applicationContext,UserDataBase::class.java,"appdatabase"
            )
                .allowMainThreadQueries()
                .build()
        }
           return INSTANCE as UserDataBase
        }
   }


}