package com.example.trader.database


import androidx.room.*
@Dao
interface UserDao{                                                                            //all queries to perform on database

    @Query("SELECT * FROM user_details ORDER BY id DESC ")
    fun getAll():List<User>

    @Insert(onConflict = OnConflictStrategy.IGNORE )
    suspend fun insertUser(user: User?)

    @Query("SELECT password FROM User_details WHERE email == :email1")
    suspend fun findByPassword(email1:String):String

    @Query("SELECT name FROM User_details WHERE email==:email2")
    fun findmyname(email2: String):String
    @Query("SELECT id FROM User_details WHERE email==:email1")
    fun findmyid(email1: String):Int

    @Delete
    fun deleteUser(user: User?)

    @Query("UPDATE user_details SET name=:newName WHERE email=:email")
    fun updateUser(newName: String, email: String)
}
