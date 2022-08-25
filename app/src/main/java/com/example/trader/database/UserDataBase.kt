package com.example.trader.database


import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities=[User::class],version=2, exportSchema = false)
abstract class UserDataBase: RoomDatabase() {
    abstract fun userdao():UserDao
   companion object{
       @Volatile
        private var INSTANCE:UserDataBase?=null

       fun getappdatabase(context: Context?): UserDataBase? {
        val temp= INSTANCE
        if(temp==null){
            synchronized(this){
            val instance=Room.databaseBuilder(
                context!!.applicationContext,UserDataBase::class.java,"appdatabase"
            )   .fallbackToDestructiveMigration()
                .build()
            INSTANCE=instance
                return instance
            }
        }
           return temp
        }
   }


}