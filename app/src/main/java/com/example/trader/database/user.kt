package com.example.trader.database


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="User_details")
data class User(
    @PrimaryKey(autoGenerate = true)var id:Int,
    @ColumnInfo var email:String,
    @ColumnInfo var password:String,
    @ColumnInfo var name:String
)
