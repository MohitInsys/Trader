package com.example.trader.database


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="User_details")
data class User(
    @PrimaryKey(autoGenerate = true)
    var id:Int,
    var email:String,
    var password:String,
    var name:String
)
